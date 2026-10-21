// Preconditions: signed-in reporter; master data cached; test image on device; Android ADB and network controls are available.
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Hazard')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Report Hazard')
    CustomKeywords.'wemine.WeMineKeywords.selectMobileOption'('Location', CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_LOCATION'))
    CustomKeywords.'wemine.WeMineKeywords.selectMobileOption'('Sublocation', CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_SUBLOCATION'))
    CustomKeywords.'wemine.WeMineKeywords.selectMobileOption'('Area', CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_AREA'))
    CustomKeywords.'wemine.WeMineKeywords.attachEvidenceFromGallery'()
    CustomKeywords.'wemine.WeMineKeywords.setAndroidNetworkEnabled'(false)
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Submit Hazard')
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'('Queued', 15)
    CustomKeywords.'wemine.WeMineKeywords.setAndroidNetworkEnabled'(true)
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'('Synced', 60)
} finally {
    try { CustomKeywords.'wemine.WeMineKeywords.setAndroidNetworkEnabled'(true) } catch (Exception ignored) {}
    CustomKeywords.'wemine.WeMineKeywords.closeMobile'()
}
// Confirm exactly one hazard and one associated follow-up task in backend/admin data after reconnect.
