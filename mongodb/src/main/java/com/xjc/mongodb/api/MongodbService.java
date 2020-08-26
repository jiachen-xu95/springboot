package com.xjc.mongodb.api;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.List;

/**
 * @Version 1.0
 * @ClassName MongodbService
 * @Author jiachenXu
 * @Date 2020/8/26 22:11
 * @Description
 */
public interface MongodbService {

    /**
     * 集合是否存在
     *
     * @param collectionName 集合名称
     * @return 执行结果
     */
    boolean exists(String collectionName);

    /**
     * 创建集合
     *
     * @param collectionNam 集合名称
     * @return 集合名称
     */
    String createCollection(String collectionNam);

    /**
     * 获取集合信息
     *
     * @param collectionName 集合名称
     * @return 集合
     */
    MongoCollection<Document> getCollection(String collectionName);

    /**
     * 删除集合
     *
     * @param collectionName 集合名称
     */
    boolean dropCollection(String collectionName);

    /**
     * 插入文档
     *
     * @param entity         文档模型
     * @param collectionName 集合名称
     * @return 执行结果
     */
    boolean insert(Object entity, String collectionName);

    /**
     * 批量插入文档
     *
     * @param entitys        文档集合
     * @param collectionName 集合名称
     * @return 执行结果
     */
    boolean insertAll(List<Object> entitys, String collectionName);

    /**
     * 删除文档
     *
     * @param key            条件字段
     * @param condition      条件
     * @param limit          删除数量
     * @param entity         映射模型
     * @param collectionName 集合名称
     * @return 执行结果
     */
    boolean remove(String key, Object condition, int limit, Object entity, String collectionName);

    /**
     * 删除该集合全部文档
     *
     * @param entity         映射模型
     * @param collectionName 集合名称
     * @return 执行结果
     */
    boolean removeAll(Object entity, String collectionName);

    /**
     * 更新文档
     *
     * @param key            条件字段
     * @param condition      条件
     * @param field          更新字段
     * @param newData        新数据
     * @param multi          是否批量
     * @param entity         映射模型
     * @param collectionName 集合名称
     * @return 执行结果
     */
    boolean update(String key, Object condition, String field, Object newData, boolean multi, Object entity, String collectionName);

    /**
     * 查询文档
     *
     * @param key            条件字段
     * @param condition      条件
     * @param entity         映射模型
     * @param collectionName 集合名称
     * @return 文档集合
     */
    List<Object> findFilter(String key, Object condition, Object entity, String collectionName);

    /**
     * 查询文档
     *
     * @param collectionName 集合名称
     * @return 文档
     */
    Object findFirst(String collectionName);

    /**
     * 分页查询文档
     *
     * @param key            条件字段
     * @param condition      条件
     * @param pageNum        起始页
     * @param pageSize       页长度
     * @param entity         映射模型
     * @param desc           是否倒序
     * @param field          排序字段
     * @param collectionName 集合名称
     * @return 文档集合
     */
    List<Object> findPagination(String key, Object condition, int pageNum, int pageSize, Object entity, boolean desc, String field, String collectionName);

    /**
     * 根据id查询文档
     *
     * @param id             文档id
     * @param entity         映射模型
     * @param collectionName 集合名称
     * @return 文档
     */
    Object findById(String id, Object entity, String collectionName);
}
