package com.tale.model.params;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author biezhi
 * @date 2018/6/9
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=false)
public class ArticleParam extends PageParam {

    private String title;
    private String categories;
    private String status;
    private String type;
    private String orderBy;

}
