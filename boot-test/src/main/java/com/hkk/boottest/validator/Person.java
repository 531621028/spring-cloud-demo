package com.hkk.boottest.validator;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.groups.Default;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;

/**
 * @author kang
 * @since 2021/1/27
 */
@Getter
@Setter
@ToString
public class Person {
    // 错误消息message是可以自定义的
    @NotNull(message = "{message} -> 名字不能为null", groups = Simple.class)
    public String name;
    @Max(value = 10, groups = Simple.class)
    @Positive(groups = Default.class) // 内置的分组：default
    public Integer age;

    @NotNull(groups = Complex.class)
    @NotEmpty(groups = Complex.class)
    private List<@Email String> emails;
    @Future(groups = Complex.class)
    private Date start;

    // 定义两个组 Simple组和Complex组
    interface Simple {
    }
    interface Complex {

    }

    public static void main(String[] args) {
        System.out.println(null == null);
        Person person = new Person();
        person.setName("fsx");
//        person.setAge(18);
        // email校验：虽然是List都可以校验哦
        person.setEmails(Arrays.asList("fsx@gmail.com", "baidu@baidu.com", "aaa.com"));
        //person.setStart(new Date()); //start 需要是一个将来的时间: Sun Jul 21 10:45:03 CST 2019
        //person.setStart(new Date(System.currentTimeMillis() + 10000)); //校验通过

        HibernateValidatorConfiguration configure = Validation.byProvider(HibernateValidator.class).configure();
        ValidatorFactory validatorFactory = configure.failFast(false).buildValidatorFactory();
        // 根据validatorFactory拿到一个Validator
        Validator validator = validatorFactory.getValidator();


        // 分组校验（可以区分对待Default组、Simple组、Complex组）
        Set<ConstraintViolation<Person>> result = validator.validate(person, Person.Simple.class);
        //Set<ConstraintViolation<Person>> result = validator.validate(person, Person.Complex.class);

        // 对结果进行遍历输出
        result.stream().map(v -> v.getPropertyPath() + " " + v.getMessage() + ": " + v.getInvalidValue())
            .forEach(System.out::println);

    }
}
