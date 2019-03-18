package org.lc.springboot.dao.mapper;

import org.lc.springboot.entity.pojo.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentMapper {

    int save(Student student);

    int saveSelective(Student student);

    int saveStudentList(List<Student> students);

    int saveStudentAndReturnKey(Student student);

    @Insert("insert into student (name, age, gender) value (#{name}, #{age}, #{gender})")
    int saveStudentBaseInfo(Student student);

    int saveOrUpdate(Student student);

    int saveExistIgnore(Student student);

    int saveOrReplace(Student student);

    int saveWithDynamicSql(Student student);

    @Delete("delete from student where id = #{id}")
    int delete(int id);

    int deleteByName(String name);

    @Update("update student set age = #{age} where id = #{id}")
    int updateAgeById(Student student);

    int updateAndReturnPrimaryKey(Student student);

    /**
     * 根据ID查询学生
     * @param id-ID
     * @return 学生信息
     */
    Student get(int id);

    List<Student> getSameNameStudent(String name);

    /**
     * 查询同名同龄学生
     * @param name-姓名
     * @param age-年龄
     * @return 学生信息
     */
    List<Student> getSameNameAndAgeStudent(String name, int age);

    /**
     * 查询最大年纪
     * 采用注解查询
     * @return 最大年龄
     */
    @Select("select max(age) from student")
    Integer getOldestStudent();

    @Select("select name, age, address from student where id = #{id}")
    @Results({
            @Result(column = "name", property = "name"),
            @Result(column = "age", property = "age"),
            @Result(column = "address", property = "address")
    })
    Student getStudentBaseInfo(int id);

    List<Student> getStudentsByClassId(int id);
}
