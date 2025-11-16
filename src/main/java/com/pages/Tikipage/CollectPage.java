package com.pages.Tikipage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.devtools.v117.domstorage.model.Item;
import org.openqa.selenium.interactions.Actions; 
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.pages.BasePage;


public class CollectPage extends BasePage{
    public CollectPage(WebDriver givenDriver) {
        super(givenDriver);
    }


public By MenuItem = By.xpath("(//div[@class='sc-9f1e84db-3 jhfSVS'])[1]");
public By ItemView = By.xpath("(//div[@class='sc-d785edce-0 gjLnmh'])[1]");
// steps click item
public CollectPage clickMenu() {

        wait.until(ExpectedConditions.elementToBeClickable(MenuItem)).click();
        return this;
    }   
// choose one item
public CollectPage clickItem() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 1. Tìm và chờ phần tử hiển thị (Bắt buộc phải tìm được trước khi cuộn)
        // 💡 Sử dụng wait.until() trực tiếp nếu waitElementVisible không có
        WebElement targetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(ItemView)); 

        // 2. Lấy tọa độ Y của phần tử
        int yCoordinate = targetElement.getLocation().getY();

        // 3. Đặt Offset an toàn (giả sử header 150px)
        int offset = 300; 
        int targetScrollPosition = yCoordinate - offset;

        // 4. SỬ DỤNG SMOOTH SCROLL (Cuộn từ từ)
        // Cuộn đến vị trí an toàn (targetScrollPosition)
        String script = String.format("window.scrollTo({ top: %d, behavior: 'smooth' });", targetScrollPosition);
        js.executeScript(script);

        // 5. Chờ sau khi cuộn để trình duyệt hoàn tất animation
        // 💡 Tăng thời gian chờ lên 500ms-1000ms là hợp lý cho smooth scroll
        try { 
            Thread.sleep(1000); // 1 giây cho cuộn mượt 
        } catch (InterruptedException e) { 
            Thread.currentThread().interrupt(); 
        }

        // 6. Click: Tìm lại phần tử và chờ clickability
        wait.until(ExpectedConditions.elementToBeClickable(ItemView)).click(); 
        return this;
        // WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(ItemView)); 
        // js.executeScript("arguments[0].click();", clickableElement);
    }
}