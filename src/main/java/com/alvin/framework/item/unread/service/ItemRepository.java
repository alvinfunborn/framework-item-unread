package com.alvin.framework.item.unread.service;

import java.util.List;

/**
 * datetime 2019/5/9 10:45
 *
 * @author sin5
 */
public interface ItemRepository<T> {

    /**
     * list all items
     *
     * @param userId userId
     * @return T list
     */
    List<T> listItems(String userId);

    /**
     * list all unread items
     *
     * @param userId userId
     * @param latestReadItemId id of latest read item
     * @return T list
     */
    List<T> listUnreadItems(String userId, String latestReadItemId);
}
