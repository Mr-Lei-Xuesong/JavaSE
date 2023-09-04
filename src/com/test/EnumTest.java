package com.test;

/**
 * Author:   lxs
 * Date:     2022/4/29 20:47
 * Description: 枚举测试
 */
public class EnumTest {
    public static void main(String[] args) {
        Season[] values = Season.values();
        for (Season value : values) {
            System.out.println(value);
            value.show();
        }
    }
}

interface Info {
    void show();
}

enum Season implements Info {
    SPRING("春天", "万物复苏") {
        @Override
        public void show() {
            System.out.println("一元复始、万物复苏");
        }
    },
    SUMMER("夏天", "烈日炎炎") {
        @Override
        public void show() {
            System.out.println("蝉声阵阵、烈日当空");
        }
    },
    AUTUMN("秋天", "金秋送爽") {
        @Override
        public void show() {
            System.out.println("天高气清、金桂飘香");
        }
    },
    WINTER("冬天", "白雪皑皑") {
        @Override
        public void show() {
            System.out.println("寒冬腊月、滴水成冰");
        }
    };

    private final String name;

    private final String desc;

    Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
