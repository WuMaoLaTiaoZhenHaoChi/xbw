package thread.thread02.thread1030;

/**
 * @Author: DuanTong
 * @Date: 2019/10/30 22:16
 */
public class MyThread103002 {

    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass(" usernameValue", " passwordValue ");
        System.out.println(publicClass.toString());
        PublicClass.PrivateClss privateClss = publicClass.new PrivateClss(12, " Shanxi");
        System.out.println(privateClss.toString());
    }
}

class PublicClass{
    private String username;
    private String password;

    public PublicClass(String username, String password) {
        this.username = username;
        this.password = password;
    }

    class PrivateClss{
        private int age;
        private String address;

        public PrivateClss(int age, String address) {
            this.age = age;
            this.address = address;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "privateClss{" +
                    "age=" + age +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PublicClass{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
