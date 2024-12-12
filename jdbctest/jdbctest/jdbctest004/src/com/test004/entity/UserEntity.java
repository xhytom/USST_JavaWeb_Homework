public class UserEntity {
    private Long id;
    private String phone;
    private String password;

    public UserEntity() {
    }

    public UserEntity(String phone, String password) {
        this.id = null;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public UserEntity(Long id, String phone, String password) {
        this.id = id;
        this.phone = phone;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
