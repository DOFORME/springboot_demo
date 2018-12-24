package com.lc.springboot.demo.entity.pojo;

import com.lc.springboot.demo.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 学生实体类
 * @author lc
 * @date 2018-12-13 21:09:14
 * @version 1.0.0
 *
 */
@Alias("student")
@Getter
@Setter
@ToString
public class Student extends BaseEntity {

    private static final long serialVersionUID = -2418011761296364471L;


    @NotNull(message = "姓名不得为空", groups = {SaveValidate.class, UpdateValidate.class})
    @Size(min = 2, max = 4, message = "姓名长度只能在2~4个字符之间", groups = {SaveValidate.class})
    private String name;

    @Min(value = 0, message = "年龄不得低于0")
    @Max(value = 120, message = "年龄不得超过120")
    private Integer age;

    @NotNull(message = "性别不能为空", groups = {UpdateValidate.class})
    private String gender;

    private String address;

    private List<Course> courses;

    /**
     * 保存请求分组验证接口
     */
    public interface SaveValidate {}

    /**
     * 更新请求分组接口
     */
    public interface UpdateValidate {}
}
