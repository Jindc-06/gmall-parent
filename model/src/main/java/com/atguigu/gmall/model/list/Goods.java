package com.atguigu.gmall.model.list;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.List;

/**
 * @Date 2021/5/26 19:54
 * @Author JINdc
 **/
@Data
@Document(indexName = "goods",type = "info",shards = 3,replicas = 1)
public class Goods {

    //商品id
    @Id
    private Long id;
    //默认图片
    @Field(type = FieldType.Keyword,index = false)
    private String defaultImg;
    //商品标题
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String title;
    //商品价格
    @Field(type = FieldType.Double)
    private Double price;
    //创建时间
    @Field(type = FieldType.Date)
    private Date createTime;
    //品牌id
    @Field(type = FieldType.Long)
    private Long tmId;
    //品牌名称
    @Field(type = FieldType.Keyword)
    private String tmName;
    // 品牌的logo
    @Field(type = FieldType.Keyword)
    private String tmLogoUrl;

    // 一级分类Id
    @Field(type = FieldType.Long)
    private Long category1Id;

    @Field(type = FieldType.Keyword)
    private String category1Name;

    @Field(type = FieldType.Long)
    private Long category2Id;

    @Field(type = FieldType.Keyword)
    private String category2Name;

    @Field(type = FieldType.Long)
    private Long category3Id;

    @Field(type = FieldType.Keyword)
    private String category3Name;

    // 热度排名
    @Field(type = FieldType.Long)
    private Long hotScore = 0L;

    // 平台属性集合对象
    // Nested 支持嵌套查询
    @Field(type = FieldType.Nested)
    private List<SearchAttr> attrs;

}
