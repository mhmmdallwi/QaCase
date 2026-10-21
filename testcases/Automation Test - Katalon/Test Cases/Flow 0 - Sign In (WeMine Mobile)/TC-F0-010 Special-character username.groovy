// Robustness check: the brief does not define allowed username characters; the value must not authenticate unexpectedly.
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.setMobileField'('Username', 'user@domain!#')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Continue')
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileFieldPresent'('Username', 10)
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileTextNotPresent'('Equipment Inspection', 3)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeMobile'() }
