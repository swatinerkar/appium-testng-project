package pageObjects;

import org.testng.annotations.BeforeMethod;
import pageObjects.nativeApp.*;
import testBase.Base;

public class AllPageObjectsNativeApp extends Base {
    protected HomePage homePage;
    protected PreferencePage preferencePage;
    protected PreferenceDependencies preferenceDependencies;
    protected ExpandableLists expandableLists;
    protected CustomAdapter customAdapter;
    protected ViewsPage viewsPage;
    protected GalleryPage galleryPage;
    protected PhotosPage photosPage;
    protected DragAndDropPage dragAndDropPage;
    protected AppPage appPage;
    protected AlertDialogs alertDialogs;

    @BeforeMethod(enabled = true)
    public void initPages(){
        homePage = new HomePage(driver);
        preferencePage = new PreferencePage(driver);
        preferenceDependencies = new PreferenceDependencies(driver);
        viewsPage = new ViewsPage(driver);
        expandableLists = new ExpandableLists(driver);
        customAdapter = new CustomAdapter(driver);
        galleryPage = new GalleryPage(driver);
        photosPage = new PhotosPage(driver);
        dragAndDropPage = new DragAndDropPage(driver);
        appPage = new AppPage(driver);
        alertDialogs = new AlertDialogs(driver);
    }
}
