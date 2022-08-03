package utilities.role_matrix;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleMatrix {
    /**
     * <p> Staff Role Matrix Table </p>
     * <p> column 1: staff role id </p>
     * <p> column 2 -> 54: permit access to page (0: no permission, 1: have permission) </p>
     */
    public Map<Integer, List<Integer>> staffRoleEncode() {
        Map<Integer, List<Integer>> staffRoleEncode = new HashMap<>();
        staffRoleEncode.put(0, List.of(1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        staffRoleEncode.put(1, List.of(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        staffRoleEncode.put(2, List.of(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        staffRoleEncode.put(3, List.of(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0));
        staffRoleEncode.put(4, List.of(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        staffRoleEncode.put(5, List.of(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1));
        staffRoleEncode.put(6, List.of(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        staffRoleEncode.put(7, List.of(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        staffRoleEncode.put(8, List.of(1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        staffRoleEncode.put(9, List.of(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        staffRoleEncode.put(10, List.of(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        staffRoleEncode.put(11, List.of(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        staffRoleEncode.put(12, List.of(1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        staffRoleEncode.put(13, List.of(1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        staffRoleEncode.put(14, List.of(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        return staffRoleEncode;
    }

    /**
     * <p> Staff Role Title Table </p>
     * <p> column 1: staff role id </p>
     * <p> column 2: staff role title </p>
     */

    public Map<Integer, String> staffRoleText() {
        Map<Integer, String> staffRoleText = new HashMap<>();
        staffRoleText.put(0, "Products");
        staffRoleText.put(1, "Marketing");
        staffRoleText.put(2, "Orders");
        staffRoleText.put(3, "Sales chanel");
        staffRoleText.put(4, "Analytics");
        staffRoleText.put(5, "Settings");
        staffRoleText.put(6, "Discount");
        staffRoleText.put(7, "Customers");
        staffRoleText.put(8, "GoChat");
        staffRoleText.put(9, "Services");
        staffRoleText.put(10, "Call center");
        staffRoleText.put(11, "Reservations");
        staffRoleText.put(12, "Supplier management");
        staffRoleText.put(13, "Purchase order");
        staffRoleText.put(14, "Cashbook");
        return staffRoleText;
    }

    /**
     * <p> List page in GoSell </p>
     * <p> column 1: page id </p>
     * <p> column 2: page title </p>
     */
    public Map<Integer, String> pageList() {
        Map<Integer, String> pageList = new HashMap<>();
        pageList.put(0, "Admin Staging - Home");
        pageList.put(1, "Admin Staging - Conservation");
        pageList.put(2, "Admin Staging - Configuration");
        pageList.put(3, "Admin Staging - Automation");
        pageList.put(4, "Admin Staging - Broadcast");
        pageList.put(5, "Admin Staging - GoSocial Zalo");
        pageList.put(6, "Admin Staging - Products");
        pageList.put(7, "Admin Staging - Inventory");
        pageList.put(8, "Admin Staging - Transfer");
        pageList.put(9, "Admin Staging - Product collections");
        pageList.put(10, "Admin Staging - Reviews");
        pageList.put(11, "Admin Staging - Supplier");
        pageList.put(12, "Admin Staging - Purchase Order");
        pageList.put(13, "Admin Staging - Services");
        pageList.put(14, "Admin Staging - Product collections");
        pageList.put(15, "Admin Staging - Orders");
        pageList.put(16, "Admin Staging - Return Orders");
        pageList.put(17, "Admin Staging - Create Quotation");
        pageList.put(18, "Admin Staging - Order 1 | POS - Instore purchase");
        pageList.put(19, "Admin Staging - Reservations");
        pageList.put(20, "Admin Staging - Discounts");
        pageList.put(21, "Admin Staging - Flash sale management");
        pageList.put(22, "Admin Staging - Customers");
        pageList.put(23, "Admin Staging - Customer segment");
        pageList.put(24, "Admin Staging - Call center");
        pageList.put(25, "Admin Staging - Cashbook");
        pageList.put(26, "Admin Staging - Orders Analytics");
        pageList.put(27, "Admin Staging - Reservations Analytics");
        pageList.put(28, "Admin Staging - Landing page");
        pageList.put(29, "Admin Staging - Buy Link");
        pageList.put(30, "Admin Staging - Email Campaigns");
        pageList.put(31, "Admin Staging - Notification");
        pageList.put(32, "Admin Staging - Loyalty Program");
        pageList.put(33, "Admin Staging - Google Analytics");
        pageList.put(34, "Admin Staging - Google Shopping");
        pageList.put(35, "Admin Staging - Google Tag Manager");
        pageList.put(36, "Admin Staging - Facebook Pixel");
        pageList.put(37, "Admin Staging - Loyalty point program");
        pageList.put(38, "Admin Staging - Affiliate");
        pageList.put(39, "Admin Staging - Theme management");
        pageList.put(40, "Admin Staging - Blog management");
        pageList.put(41, "Admin Staging - Pages");
        pageList.put(42, "Admin Staging - Menu");
        pageList.put(43, "Admin Staging - Domains");
        pageList.put(44, "Admin Staging - Preferences");
        pageList.put(45, "Admin Staging - Shopee");
        pageList.put(46, "Admin Staging - Shopee product management");
        pageList.put(47, "Admin Staging - Link Products");
        pageList.put(48, "Admin Staging - Shopee");
        pageList.put(49, "Admin Staging - Settings");
        pageList.put(50, "Admin Staging - Lazada");
        pageList.put(51, "Admin Staging - title.[/channel/gomua/account]");
        pageList.put(52, "Admin Staging - Settings");
        return pageList;
    }

    /**
     * <p> List page in GoSell </p>
     * <p> column 1: page id </p>
     * <p> column 2: page path </p>
     */
    public Map<Integer, String> pagePath() {
        Map<Integer, String> pagePath = new HashMap<>();
        pagePath.put(0, "/home");
        pagePath.put(1, "/gosocial/facebook/conversations");
        pagePath.put(2, "/gosocial/facebook/configuration");
        pagePath.put(3, "/gosocial/facebook/automation");
        pagePath.put(4, "/gosocial/facebook/broadcast");
        pagePath.put(5, "/gosocial/zalo/intro");
        pagePath.put(6, "/product/list");
        pagePath.put(7, "/inventory/list");
        pagePath.put(8, "/product/transfer/list");
        pagePath.put(9, "/collection/list");
        pagePath.put(10, "/review_product/list");
        pagePath.put(11, "/supplier/list");
        pagePath.put(12, "/product/purchase-order/list");
        pagePath.put(13, "/service/list");
        pagePath.put(14, "/collection_service/list");
        pagePath.put(15, "/order/list");
        pagePath.put(16, "/order/return-order/list");
        pagePath.put(17, "/order/instore-quotation");
        pagePath.put(18, "/order/instore-purchase");
        pagePath.put(19, "/reservation/list");
        pagePath.put(20, "/discounts/list");
        pagePath.put(21, "/flash-sale/list");
        pagePath.put(22, "/all-customers/list");
        pagePath.put(23, "/segments/list");
        pagePath.put(24, "/setting/call-center");
        pagePath.put(25, "/cashbook/management");
        pagePath.put(26, "/analytics/order");
        pagePath.put(27, "/analytics/reservation");
        pagePath.put(28, "/marketing/landing-page/list");
        pagePath.put(29, "/marketing/buy-link/list");
        pagePath.put(30, "/marketing/email/list");
        pagePath.put(31, "/marketing/notification");
        pagePath.put(32, "/marketing/loyalty/list");
        pagePath.put(33, "/marketing/google-analytics");
        pagePath.put(34, "/marketing/google-shopping");
        pagePath.put(35, "/marketing/google-tag-manager");
        pagePath.put(36, "/marketing/facebook-pixel");
        pagePath.put(37, "/marketing/loyalty-point/setting");
        pagePath.put(38, "/affiliate");
        pagePath.put(39, "/theme/management");
        pagePath.put(40, "/channel/storefront/blog/article/list");
        pagePath.put(41, "/channel/storefront/custom-page");
        pagePath.put(42, "/channel/storefront/menu");
        pagePath.put(43, "/channel/storefront/domain");
        pagePath.put(44, "/channel/storefront/preference");
        pagePath.put(45, "/channel/shopee/account/information");
        pagePath.put(46, "/channel/shopee/product/list");
        pagePath.put(47, "/channel/shopee/link-products");
        pagePath.put(48, "/channel/shopee/account/management");
        pagePath.put(49, "/channel/shopee/settings");
        pagePath.put(50, "/channel/lazada/account");
        pagePath.put(51, "/channel/gomua/account");
        pagePath.put(52, "/setting");
        return pagePath;
    }
}