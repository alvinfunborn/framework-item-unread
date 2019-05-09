package com.alvin.framework.item.unread.service;

/**
 * datetime 2019/5/9 10:45
 *
 * @author sin5
 */
public interface ReadRecorder<T> {

    /**
     * mark read
     *
     * @param userId userId
     * @param item item
     */
    void markLatestRead(String userId, T item);

    /**
     * get latest read item id
     *
     * @param userId userId
     * @return item
     */
    String getLatestRead(String userId);
}
