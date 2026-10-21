// Preconditions: signed-in reporter, synced master data, and a test image available in the Android gallery.
// Verify that the required Evidence control can launch the gallery and accept an image.
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Hazard')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Report Hazard')
    CustomKeywords.'wemine.WeMineKeywords.tapMobileField'('Location')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'(CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_LOCATION'))
    CustomKeywords.'wemine.WeMineKeywords.tapMobileField'('Sublocation')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'(CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_SUBLOCATION'))
    CustomKeywords.'wemine.WeMineKeywords.tapMobileField'('Area')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'(CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_AREA'))
    CustomKeywords.'wemine.WeMineKeywords.attachEvidenceFromGallery'()

    TestObject attachedImage = new TestObject('attachedEvidencePreview')
    attachedImage.addProperty('xpath', ConditionType.EQUALS,
        "//*[@content-desc and (contains(translate(@content-desc,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'photo') or contains(translate(@content-desc,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'image') or contains(translate(@content-desc,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'evidence'))] | //*[@resource-id and (contains(translate(@resource-id,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'thumbnail') or contains(translate(@resource-id,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'evidence'))]")
    Mobile.waitForElementPresent(attachedImage, 10)
} finally {
    CustomKeywords.'wemine.WeMineKeywords.closeMobile'()
}
