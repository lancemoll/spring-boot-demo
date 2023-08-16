package com.xkcoding.sharding.jdbc.utils;

import com.google.common.hash.Hashing;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public final class ConsistentHashUtils {
    private ConsistentHashUtils() {
    }

    public static String getCollection(Collection<String> collection, String vid) {
        return getCollection(collection, (long)getHash(vid), 0);
    }

    public static String getCollection(Collection<String> collection, String vid, int virtualNodeNums) {
        return getCollection(collection, (long)getHash(vid), virtualNodeNums);
    }

    public static String getCollection(Collection<String> collection, long vid) {
        return getCollection(collection, vid, 0);
    }

    public static String getCollection(Collection<String> collection, long vid, int virtualNodeNums) {
        String splitStr = "&&";
        List<String> realNodes = new LinkedList();
        collection.forEach((c) -> {
            realNodes.add(c);
        });
        List<String> virtualNodes = new LinkedList();
        if (virtualNodeNums > 0) {
            Iterator var7 = realNodes.iterator();

            while(var7.hasNext()) {
                String str = (String)var7.next();

                for(int i = 0; i < virtualNodeNums; ++i) {
                    String virtualNodeName = str + splitStr + String.valueOf(i);
                    virtualNodes.add(virtualNodeName);
                }
            }
        } else {
            virtualNodes.addAll(realNodes);
        }

        int buckets = virtualNodes.size();
        int bucket = Hashing.consistentHash(vid, buckets);
        if (Objects.isNull(vid)) {
            throw new UnsupportedOperationException("vid must not be empty!");
        } else {
            String currentVirtualNode = (String)virtualNodes.get(bucket);
            return StringUtils.substringBeforeLast(currentVirtualNode, splitStr);
        }
    }

    public static int getHash(String str) {
        int p = 16777619;
        int hash = -2128831035;

        for(int i = 0; i < str.length(); ++i) {
            hash = (hash ^ str.charAt(i)) * 16777619;
        }

        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        if (hash < 0) {
            hash = Math.abs(hash);
        }

        return hash;
    }
}
