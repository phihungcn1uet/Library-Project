package Model;

/**
 *
 * @author admin
 */
public class User {

    private String idUser, userName, birthday, address, phoneNumber, identityNumber, sex, accountName, password;
    private int role, prestige;
    private byte[] image; 
    
    /**
     *
     */
    public User() {
        
    }

    /**
     *
     * @param idUser
     * @param userName
     * @param birthday
     * @param address
     * @param phoneNumber
     * @param identityNumber
     * @param sex
     * @param image
     */
    public User(String idUser, String userName, String birthday, String address, String phoneNumber, String identityNumber, String sex, byte[] image) {
        this.idUser = idUser;
        this.userName = userName;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.identityNumber = identityNumber;
        this.sex = sex;
        this.accountName = null;
        this.password = null;
        this.image = image;
    }

    /**
     *
     * @param idUser
     * @param userName
     * @param birthday
     * @param address
     * @param phoneNumber
     * @param identityNumber
     * @param sex
     * @param accountName
     * @param password
     * @param role
     * @param image
     */
    public User(String idUser, String userName, String birthday, String address, String phoneNumber, String identityNumber, String sex, String accountName, String password, int role, byte[] image) {
        this.idUser = idUser;
        this.userName = userName;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.identityNumber = identityNumber;
        this.sex = sex;
        this.accountName = accountName;
        this.password = password;
        this.image = image;
        this.role = role;
    }
    /**
     *
     * @param idUser
     */
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @param birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @param identityNumber
     */
    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    /**
     *
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     *
     * @return
     */
    public String getIdUser() {
        return idUser;
    }

    /**
     *
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @return
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @return
     */
    public String getIdentityNumber() {
        return identityNumber;
    }

    /**
     *
     * @return
     */
    public String getSex() {
        return sex;
    }

    /**
     *
     * @return
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     *
     * @param accountName
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public int getRole() {
        return role;
    }

    /**
     *
     * @param role
     */
    public void setRole(int role) {
        this.role = role;
    }

    /**
     *
     * @return
     */
    public int getPrestige() {
        return prestige;
    }

    /**
     *
     * @param prestige
     */
    public void setPrestige(int prestige) {
        this.prestige = prestige;
    }

    /**
     *
     * @return
     */
    public byte[] getImage() {
        return image;
    }

    /**
     *
     * @param image
     */
    public void setImage(byte[] image) {
        this.image = image;
    }
}
