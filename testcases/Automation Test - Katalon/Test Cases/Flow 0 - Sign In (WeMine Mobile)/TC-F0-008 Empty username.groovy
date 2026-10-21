CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Continue')
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileFieldPresent'('Username', 10)
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileTextNotPresent'('Microsoft', 3)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeMobile'() }
