#### 未读消息后端框架
常用于消息红点和未读条数展示

##### usage
1. 实现ItemRepository
2. 实现ReadRecorder

###### config
```$xslt
@Configuration
public class NotifierConfig {

    @Autowired
    private ReadRecorder<PrimeNoticeItem> noticeReadRecorder;
    @Autowired
    private ItemRepository<PrimeNoticeItem> noticeItemRepository;
    @Autowired
    private ReadRecorder<PrimeActivityItem> activityReadRecorder;
    @Autowired
    private ItemRepository<PrimeActivityItem> activityItemRepository;


    @Bean
    public Notifier<PrimeNoticeItem> noticeNotifier() {
        return new StandardNotifier<>(noticeReadRecorder, noticeItemRepository);
    }

    @Bean
    public Notifier<PrimeActivityItem> activityNotifier() {
        return new StandardNotifier<>(activityReadRecorder, activityItemRepository);
    }
}

```

###### service
```$xslt
@Service
public class Service {
    
    @Autowired
    private Notifier<PrimeNoticeItem> noticeNotifier;
    
    public int unreadCount(String userId) {
        return noticeNotifier.unreadCount(userId);
    }
}
```