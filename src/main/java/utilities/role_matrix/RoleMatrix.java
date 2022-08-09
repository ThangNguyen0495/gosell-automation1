package utilities.role_matrix;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import utilities.excel.Excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleMatrix {

    public Map<Integer, List<Integer>> staffPermissions(String fileName) throws IOException {
        Map<Integer, List<Integer>> rolePage = new HashMap<>();
        Sheet sheet = new Excel().getSheet(fileName, 0);
        int maxRow = sheet.getLastRowNum();
        int maxCell = sheet.getRow(0).getLastCellNum();
        List<Integer> roleList;
        for (int cellNum = 3; cellNum < maxCell; cellNum++) {
            roleList = new ArrayList<>();
            for (int rowNum = 1; rowNum <= maxRow; rowNum++) {
                roleList.add(Integer.valueOf(new DataFormatter().formatCellValue(sheet.getRow(rowNum).getCell(cellNum))));
            }
            rolePage.put(cellNum - 3, roleList);
        }
        return rolePage;
    }

    public Map<Integer, String> permissionText(String fileName) throws IOException {
        Map<Integer, String> permissionText = new HashMap<>();
        Row row = new Excel().getSheet(fileName, 0).getRow(0);
        for (int cellNum = 3; cellNum < row.getLastCellNum(); cellNum++) {
            permissionText.put(cellNum - 3, new DataFormatter().formatCellValue(row.getCell(cellNum)));
        }
        return permissionText;
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
        pagePath.put(22, "/customers/all-customers/list");
        pagePath.put(23, "/customers/segments/list");
        pagePath.put(24, "/call-center/intro");
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