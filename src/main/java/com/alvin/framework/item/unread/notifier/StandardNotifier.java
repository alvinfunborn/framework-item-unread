package com.alvin.framework.item.unread.notifier;

import com.alvin.framework.item.unread.service.ItemRepository;
import com.alvin.framework.item.unread.service.ReadRecorder;

import java.util.ArrayList;
import java.util.List;

/**
 * datetime 2019/5/9 11:14
 *
 * @author sin5
 */
public class StandardNotifier<T> implements Notifier<T> {

    private ReadRecorder<T> readRecorder;
    private ItemRepository<T> itemRepository;

    public StandardNotifier(ReadRecorder<T> readRecorder, ItemRepository<T> itemRepository) {
        this.readRecorder = readRecorder;
        this.itemRepository = itemRepository;
    }

    @Override
    public boolean hasUnread(String userId) {
        return unreadCount(userId, false) > 0;
    }

    @Override
    public int unreadCount(String userId, boolean markRead) {
        return listUnread(userId, markRead).size();
    }

    @Override
    public List<T> listUnread(String userId, boolean markRead) {
        String latestReadItemId = readRecorder.getLatestRead(userId);
        List<T> list;
        if (latestReadItemId != null) {
            list = itemRepository.listUnreadItems(userId, latestReadItemId);
        } else {
            list = itemRepository.listItems(userId);
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        if (markRead && !list.isEmpty()) {
            readRecorder.markLatestRead(userId, list.get(0));
        }
        return list;
    }
}
