package practice_interface;

/**
 * Thiê kế Interface cho phép quản lí tào khoản goomg các thao tác:
 * -- đăng kí
 * -- đăng nhập
 * -- đăng xuất
 * -- xóa tài khoản
 * -- vô hiệu hóa tào khoản
 * -- khôi phục tài khoản
 * -- dổi mật kh
 * -- cấp lại mật khẩu
 * --chỉnh sửa thông tin tài khoản
 */

public interface AccountManagerment {
    boolean signup(Account account);

    boolean login(Account account);

    void logout(Account account);

    boolean removeAccount(Account account);

    boolean recoverAccount(Account account);

    boolean changePassword(Account account);

    void changeAccountInfo(Account account);

    default void deactiveAccount(Account account) {
        System.out.println("Tai khoan da bi vo hieu hoa!!!");
    }

    default String randomPassword(Account account){
        return "";
    }
}
