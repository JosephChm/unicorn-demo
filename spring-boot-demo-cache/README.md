# Redis 基础数据结构

## 1、字符串：（缓存）
### key：value
### value 可以是对象转换成的 JSON 字符串，也可以是对象序列化后的二进制字符串

## 2、列表：（异步队列） 类似linkedlist
### 右边进左边出：队列
### 右边进右边出：栈

## 3、字典（哈希） 类似hashmap：数组+链表
### 不过rehash是渐进式hash策略

## 4、集合：（去重）
### 无序 set：类似hashset
### 有序 zset：类似SortedSet和HashMap的结合体，内部实现是跳跃列表

CacheManager
描述

SimpleCacheManager
使用简单的 Collection 来存储缓存，主要用于测试

ConcurrentMapCacheManager
使用 ConcurrentMap 来存储缓存

NoOpCacheManager
仅测试用途，不会实际缓存数据

EhCacheCacheManager
使用 EhCache 作为缓存技术

GuavaCacheManager
使用 Google Guava 的 GuavaCache 作为缓存技术

HazelcastCacheManager
使用 Hazelcast 作为缓存技术

JCacheCacheManager
支持 JCache(JSR-107) 标准的实现作为缓存技术，如 ApacheCommonsJCS

RedisCacheManager
使用 Redis 作为缓存技术