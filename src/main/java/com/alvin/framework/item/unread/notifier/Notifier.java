package com.alvin.framework.item.unread.notifier;

import java.util.List;

/**
 * datetime 2019/5/9 10:43
 *
 * @author sin5
 */
public interface Notifier<T> {

    /**
     * has unread items
     *
     * @param userId userId
     * @return true user has unread items
     */
    boolean hasUnread(String userId);

    /**
     * count unread items
     *
     * @param userId userId
     * @param markRead if mark read after count
     * @return count
     */
    int unreadCount(String userId, boolean markRead);

    /**
     * list unread items
     *
     * @param userId userId
     * @param markRead if mark read after listing
     * @return T list
     */
    List<T> listUnread(String userId, boolean markRead);
}
