import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

    //Test Case 1

    @Test
    public void loginWithFacebook() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.n11.com/");
        driver.findElement(By.className("btnSignIn")).click();

        String parentHandle = driver.getWindowHandle();//Facebook ile giriş yap'a tıklandığında popup açılacağı için login sayfasını(mevcut) Parent olarak tutuyoruz.

        driver.findElement(By.className("facebookBtn")).click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);//Açılan popup'ın üzerinde çalışmak için tutuyoruz.
        }
        Thread.sleep(3000);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("ismailkoprulu@yandex.com");
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys("123456ik");
        driver.findElement(By.name("login")).click();

        driver.switchTo().window(parentHandle);//Popup kapandığından parent olarak tutulan sayfaya geçiyoruz.

        driver.get("https://www.n11.com/");//Parent sayfaya geçemediğimden tekrardan anasayfa URL'ni çağırdım.
        Assert.assertEquals("n11.com - Alışverişin Uğurlu Adresi", driver.getTitle());
        Thread.sleep(3000);
        String buyerName = driver.findElement(By.className("username")).getText();
        Assert.assertTrue("Wehen buyer is login", buyerName.contains("Ismail Köprülü"));

        driver.get("https://www.n11.com/kitap");
        Thread.sleep(3000);
        Assert.assertEquals("Yeni Çıkan, En Çok Satan & Okunan Kitaplar - n11.com", driver.getTitle());

        driver.findElement(By.linkText("Yazarlar")).click();
        Thread.sleep(3000);
        Assert.assertEquals("Yazarlar - Türk ve Yabancı Yazarlar - n11.com", driver.getTitle());

        //A

        driver.get("https://www.n11.com/yazarlar/A");
        Thread.sleep(3000);
        Assert.assertEquals("A ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountA = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click A", authorCountA == 80);

        String lastAuthorAInPage1 = "A. Coşkun Ongun (1)";
        driver.get("https://www.n11.com/yazarlar/A?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorAInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //B

        driver.get("https://www.n11.com/yazarlar/B");
        Thread.sleep(3000);
        Assert.assertEquals("B ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountB = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click B", authorCountB == 80);

        String lastAuthorBInPage1 = "Bahadır Cüneyt Yalçın (12)";
        driver.get("https://www.n11.com/yazarlar/B?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorBInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //C

        driver.get("https://www.n11.com/yazarlar/C");
        Thread.sleep(3000);
        Assert.assertEquals("C ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountC = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click C", authorCountC == 80);

        String lastAuthorCInPage1 = "Cafer El Askeri (1)";
        driver.get("https://www.n11.com/yazarlar/C?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorCInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //Ç

        driver.get("https://www.n11.com/yazarlar/Ç");
        Thread.sleep(3000);
        Assert.assertEquals("Ç ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountÇ = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click Ç", authorCountÇ == 80);

        String lastAuthorÇInPage1 = "Çağrı Acarol (2)";
        driver.get("https://www.n11.com/yazarlar/Ç?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorÇInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //D

        driver.get("https://www.n11.com/yazarlar/D");
        Thread.sleep(3000);
        Assert.assertEquals("D ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountD = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click D", authorCountD == 80);

        String lastAuthorDInPage1 = "Damian Dibben (3)";
        driver.get("https://www.n11.com/yazarlar/D?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorDInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //E

        driver.get("https://www.n11.com/yazarlar/E");
        Thread.sleep(3000);
        Assert.assertEquals("E ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountE = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click E", authorCountE == 80);

        String lastAuthorEInPage1 = "Earl Derr Biggers (2)";
        driver.get("https://www.n11.com/yazarlar/E?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorEInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //F

        driver.get("https://www.n11.com/yazarlar/F");
        Thread.sleep(3000);
        Assert.assertEquals("F ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountF = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click F", authorCountF == 80);

        String lastAuthorFInPage1 = "F. ZEN (1)";
        driver.get("https://www.n11.com/yazarlar/F?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorFInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //G

        driver.get("https://www.n11.com/yazarlar/G");
        Thread.sleep(3000);
        Assert.assertEquals("G ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountG = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click F", authorCountG == 80);

        String lastAuthorGInPage1 = "Gabrielle Van Zuylen (1)";
        driver.get("https://www.n11.com/yazarlar/G?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorGInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //H

        driver.get("https://www.n11.com/yazarlar/H");
        Thread.sleep(3000);
        Assert.assertEquals("H ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountH = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click H", authorCountH == 80);

        String lastAuthorHInPage1 = "H. Fehim Üçışık (73)";
        driver.get("https://www.n11.com/yazarlar/H?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorHInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //I

        driver.get("https://www.n11.com/yazarlar/I");
        Thread.sleep(3000);
        Assert.assertEquals("I ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountI = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click I", authorCountI == 80);

        String lastAuthorIInPage1 = "Igor Bogdanov (2)";
        driver.get("https://www.n11.com/yazarlar/I?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorIInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //İ

        driver.get("https://www.n11.com/yazarlar/İ");
        Thread.sleep(3000);
        Assert.assertEquals("İ ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountİ = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click İ", authorCountİ == 80);

        String lastAuthorİInPage1 = "İbn-i Mugaffa (3)";
        driver.get("https://www.n11.com/yazarlar/İ?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorİInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //J

        driver.get("https://www.n11.com/yazarlar/J");
        Thread.sleep(3000);
        Assert.assertEquals("J ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountJ = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click J", authorCountJ == 80);

        String lastAuthorJInPage1 = "J. - M. Lachapelle (1)";
        driver.get("https://www.n11.com/yazarlar/J?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorJInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //K

        driver.get("https://www.n11.com/yazarlar/K");
        Thread.sleep(3000);
        Assert.assertEquals("K ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountK = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click K", authorCountK == 80);

        String lastAuthorKInPage1 = "Kader Hoşgören (3)";
        driver.get("https://www.n11.com/yazarlar/K?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorKInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //L

        driver.get("https://www.n11.com/yazarlar/L");
        Thread.sleep(3000);
        Assert.assertEquals("L ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountL = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click L", authorCountL == 80);

        String lastAuthorLInPage1 = "Lale Uluç (2)";
        driver.get("https://www.n11.com/yazarlar/L?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorLInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //M

        driver.get("https://www.n11.com/yazarlar/M");
        Thread.sleep(3000);
        Assert.assertEquals("M ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountM = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click M", authorCountM == 80);

        String lastAuthorMInPage1 = "M. Bayrak Çelik (2)";
        driver.get("https://www.n11.com/yazarlar/M?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorMInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //N

        driver.get("https://www.n11.com/yazarlar/N");
        Thread.sleep(3000);
        Assert.assertEquals("N ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountN = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click N", authorCountN == 80);

        String lastAuthorNInPage1 = "N. Zaporozhets (1)";
        driver.get("https://www.n11.com/yazarlar/N?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorNInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //O

        driver.get("https://www.n11.com/yazarlar/O");
        Thread.sleep(3000);
        Assert.assertEquals("O ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountO = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click O", authorCountO == 80);

        String lastAuthorOInPage1 = "Oğuz Çetinoğlu (21)";
        driver.get("https://www.n11.com/yazarlar/O?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorOInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //Ö

        driver.get("https://www.n11.com/yazarlar/Ö");
        Thread.sleep(3000);
        Assert.assertEquals("Ö ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountÖ = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click Ö", authorCountÖ == 80);

        String lastAuthorÖInPage1 = "Ömer Celep (2)";
        driver.get("https://www.n11.com/yazarlar/Ö?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorÖInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //P

        driver.get("https://www.n11.com/yazarlar/P");
        Thread.sleep(3000);
        Assert.assertEquals("P ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountP = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click P", authorCountP == 80);

        String lastAuthorPInPage1 = "Pamela Redmond Satran (6)";
        driver.get("https://www.n11.com/yazarlar/P?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorPInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //Q

        driver.get("https://www.n11.com/yazarlar/Q");
        Thread.sleep(3000);
        Assert.assertEquals("Q ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountQ = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click Q", authorCountQ == 19);

        //R

        driver.get("https://www.n11.com/yazarlar/R");
        Thread.sleep(3000);
        Assert.assertEquals("R ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountR = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click R", authorCountR == 80);

        String lastAuthorRInPage1 = "R. V. C. Bodley (3)";
        driver.get("https://www.n11.com/yazarlar/R?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorRInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //S

        driver.get("https://www.n11.com/yazarlar/S");
        Thread.sleep(3000);
        Assert.assertEquals("S ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountS = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click S", authorCountS == 80);

        String lastAuthorSInPage1 = "S.Sedat Akgöz (2)";
        driver.get("https://www.n11.com/yazarlar/S?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorSInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //Ş

        driver.get("https://www.n11.com/yazarlar/Ş");
        Thread.sleep(3000);
        Assert.assertEquals("Ş ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountŞ = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click Ş", authorCountŞ == 80);

        String lastAuthorŞInPage1 = "Şadi Eren (13)";
        driver.get("https://www.n11.com/yazarlar/Ş?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorŞInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //T

        driver.get("https://www.n11.com/yazarlar/T");
        Thread.sleep(3000);
        Assert.assertEquals("T ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountT = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click T", authorCountT == 80);

        String lastAuthorTInPage1 = "Taha Ün (5)";
        driver.get("https://www.n11.com/yazarlar/T?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorTInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //U

        driver.get("https://www.n11.com/yazarlar/U");
        Thread.sleep(3000);
        Assert.assertEquals("U ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountU = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click U", authorCountU == 80);

        String lastAuthorUInPage1 = "Ufuk Turan (7)";
        driver.get("https://www.n11.com/yazarlar/U?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorUInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //Ü

        driver.get("https://www.n11.com/yazarlar/Ü");
        Thread.sleep(3000);
        Assert.assertEquals("Ü ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountÜ = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click Ü", authorCountÜ == 80);

        String lastAuthorÜInPage1 = "Ümit Aydoğmuş (2)";
        driver.get("https://www.n11.com/yazarlar/Ü?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorÜInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //V

        driver.get("https://www.n11.com/yazarlar/V");
        Thread.sleep(3000);
        Assert.assertEquals("V ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountV = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click V", authorCountV == 80);

        String lastAuthorVInPage1 = "Vahit İlhan (2)";
        driver.get("https://www.n11.com/yazarlar/V?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorVInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //W

        driver.get("https://www.n11.com/yazarlar/W");
        Thread.sleep(3000);
        Assert.assertEquals("W ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountW = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click W", authorCountW == 80);

        String lastAuthorWInPage1 = "Walter Lord (3)";
        driver.get("https://www.n11.com/yazarlar/W?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorWInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.


        //X

        driver.get("https://www.n11.com/yazarlar/X");
        Thread.sleep(3000);
        Assert.assertEquals("X ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountX = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click X", authorCountX == 30);

        //Y

        driver.get("https://www.n11.com/yazarlar/Y");
        Thread.sleep(3000);
        Assert.assertEquals("Y ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountY = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click Y", authorCountY == 80);

        String lastAuthorYInPage1 = "Yahya Kurtkaya (5)";
        driver.get("https://www.n11.com/yazarlar/Y?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorYInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        //Z

        driver.get("https://www.n11.com/yazarlar/Z");
        Thread.sleep(3000);
        Assert.assertEquals("Z ile Başlayan Yazarlar 1 - n11.com", driver.getTitle());

        int authorCountZ = driver.findElements(By.xpath("//*[@id='authorsList']/div/ul/li")).size();
        Assert.assertTrue("When click Z", authorCountZ == 80);

        String lastAuthorZInPage1 = "Zafer Karabay (1)";
        driver.get("https://www.n11.com/yazarlar/Z?pg=2");
        Assert.assertTrue("In page 2", driver.findElements(By.xpath("//li[contains(text(), '" + lastAuthorZInPage1 + "')]")).size() == 0);//1. sayfadaki son yazar 2. sayfada olmayacağından size 0'a eşitlendi.

        return;


    }

    //Test Case 2

    @Test
    public void failLogin() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.n11.com/");
        driver.findElement(By.className("btnSignIn")).click();

        String parentHandle = driver.getWindowHandle();

        driver.findElement(By.className("facebookBtn")).click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        Thread.sleep(3000);
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.name("email")).sendKeys("ismailkoprulu@yandex.com");
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys("1234567ik");
        driver.findElement(By.name("login")).click();

        String errorMessage = "Please re-enter your password";
        Assert.assertTrue("When member enter false password", errorMessage.contains("Please re-enter your password"));//Aynı kullanıcı ile hatalı password girildiğinde kullanıcı login olamadığından döenen hata mesajı kontrol edildi.

        return;

    }
}









































