package com.lmk.modle.optional;

import com.sun.media.sound.SoftTuning;

import java.util.Optional;

public class OptionalUseage {

    public static void main(String[] args) {
        //创建方式一
        Optional<Insurance> insurance = Optional.<Insurance>empty();

        //常见方式二
        Optional<Insurance> insurance1 = Optional.of(new Insurance());


        //创建方式三  一和二的结合
        Optional<Insurance> o = Optional.ofNullable(null);

//        方法
        //有值返回对应的值，无值 返回给定的对象 Supplier
       // o.orElseGet(Insurance::new);
        //有值返回对应的值，无值 返回给定的对象
      //  o.orElse(new Insurance());
        //有值返回对应的值，无值抛出给定的异常
        //o.orElseThrow(RuntimeException::new);

       // Insurance insurance2 = insurance1.filter(i -> i.getName() != null).get();

        Optional<String> s = insurance1.map(i -> i.getName());
       //isPresent 是否存在
        System.out.println(s.isPresent());

        //ifPresent 存在才执行动作
        System.out.println("---------ifPersent--------");
        insurance.ifPresent(t-> System.out.println(t.getName()));
        System.out.println("1111");
        s.ifPresent(t-> System.out.println(t));
        System.out.println(insurance1.isPresent());
        System.out.println(s.orElse("No zhi"));

        String insuranceNameByOptional = getInsuranceNameByOptional(null);
        System.out.println(insuranceNameByOptional);
    }


    private static String getInsuranceNameByOptional(Insurance insurance){
        //不知道有没有值 用ofNullable()
      return  Optional.ofNullable(insurance).map(Insurance::getName).orElse("No zhi");

    }
}
