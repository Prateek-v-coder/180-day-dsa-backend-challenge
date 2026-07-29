package development_topics.Design_pattern;

public class Builder_pattern {
    public static void main(String[] args) {
        Builder_pattern b = new Builder_pattern
                .Builder("prateek",21)
                .city("lucknow")
                .course("B.tech cse")
                .build();
        System.out.println(b);

    }
    private String name;
    private int age;
    private String city;
    private String course;
    public Builder_pattern(Builder b){
        this.name=b.name;
        this.age=b.age;
        this.city=b.city;
        this.course= b.course;

    }
    public static class Builder{
        private String name;
        private int age;
        private String city;
        private String course;
        public Builder(String name, int age){
            this.name=name;
            this.age=age;
        }
        public Builder city(String city){
            this.city=city;
            return this;
        }
        public Builder course(String course){
            this.course=course;
            return this;
        }
        public Builder_pattern build() {
            return new Builder_pattern(this);
        }
    }
    @Override
    public String toString() {
        return name + " | " + age +
                " | " + city +
                " | " + course;
    }
}

