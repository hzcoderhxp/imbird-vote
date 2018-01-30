package com.stone.enumeration;

/**
 * Created by chenghao on 6/22/17.
 */
public enum PayWayEnum {
    Lianlian(1,"lianlianpay");
    Integer id;
    String name;

    PayWayEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public static PayWayEnum getById(Integer id){
        for(PayWayEnum payWay: PayWayEnum.values()){
            if(payWay.getId()==id)
                return payWay;
        }
        return null;
    }


}
