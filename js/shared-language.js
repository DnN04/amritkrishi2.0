// SHARED LANGUAGE SYSTEM - Include this in EVERY page
console.log("=== SHARED LANGUAGE SYSTEM LOADED ===");

// Global translations
const APP_TRANSLATIONS = {
    en: {
        // Navigation
        "navTitle": "AmritKrishi",
        "navFeatures": "Features",
        "navLanguage": "Language", 
        "navAbout": "About",
        
        // Location Page
        "stepLocation": "Location",
        "stepAnalysis": "Analysis",
        "stepResults": "Results",
        "formTitle": "Enter Your Farm Location",
        "formSubtitle": "We'll analyze soil and climate to recommend the best crops",
        "labelName": "Your Name",
        "labelMethod": "Choose Location Method",
        "methodCurrent": "Use Current Location",
        "methodMap": "Pick on Map", 
        "methodManual": "Enter Manually",
        "mapInstructions": "Click on your farm location",
        "labelLatitude": "Latitude",
        "labelLongitude": "Longitude",
        "btnAnalyze": "Analyze My Farm"
    },
    hi: {
        // Navigation
        "navTitle": "अमृतकृषि",
        "navFeatures": "विशेषताएं",
        "navLanguage": "भाषा",
        "navAbout": "हमारे बारे में",
        
        // Location Page
        "stepLocation": "स्थान",
        "stepAnalysis": "विश्लेषण", 
        "stepResults": "परिणाम",
        "formTitle": "अपना फार्म स्थान दर्ज करें",
        "formSubtitle": "हम सबसे अच्छी फसलों की सिफारिश करने के लिए मिट्टी और जलवायु का विश्लेषण करेंगे",
        "labelName": "आपका नाम",
        "labelMethod": "स्थान विधि चुनें",
        "methodCurrent": "वर्तमान स्थान का उपयोग करें",
        "methodMap": "मानचित्र पर चुनें",
        "methodManual": "मैन्युअल रूप से दर्ज करें",
        "mapInstructions": "अपने फार्म के स्थान पर क्लिक करें",
        "labelLatitude": "अक्षांश",
        "labelLongitude": "देशांतर", 
        "btnAnalyze": "मेरे फार्म का विश्लेषण करें"
    },
    pa: {
        // Navigation
        "navTitle": "ਅੰਮ੍ਰਿਤ ਕ੍ਰਿਸ਼ੀ",
        "navFeatures": "ਵਿਸ਼ੇਸ਼ਤਾਵਾਂ", 
        "navLanguage": "ਭਾਸ਼ਾ",
        "navAbout": "ਸਾਡੇ ਬਾਰੇ",
        
        // Location Page
        "stepLocation": "ਟਿਕਾਣਾ",
        "stepAnalysis": "ਵਿਸ਼ਲੇਸ਼ਣ",
        "stepResults": "ਨਤੀਜੇ", 
        "formTitle": "ਆਪਣਾ ਫਾਰਮ ਟਿਕਾਣਾ ਦਰਜ ਕਰੋ",
        "formSubtitle": "ਅਸੀਂ ਸਭ ਤੋਂ ਵਧੀਆ ਫਸਲਾਂ ਦੀ ਸਿਫਾਰਸ਼ ਕਰਨ ਲਈ ਮਿੱਟੀ ਅਤੇ ਜਲਵਾਯੂ ਦਾ ਵਿਸ਼ਲੇਸ਼ਣ ਕਰਾਂਗੇ",
        "labelName": "ਤੁਹਾਡਾ ਨਾਮ",
        "labelMethod": "ਟਿਕਾਣਾ ਵਿਧੀ ਚੁਣੋ",
        "methodCurrent": "ਮੌਜੂਦਾ ਟਿਕਾਣਾ ਵਰਤੋਂ",
        "methodMap": "ਨਕਸ਼ੇ 'ਤੇ ਚੁਣੋ",
        "methodManual": "ਖੁਦ ਦਰਜ ਕਰੋ", 
        "mapInstructions": "ਆਪਣੇ ਫਾਰਮ ਦੇ ਟਿਕਾਣੇ 'ਤੇ ਕਲਿਕ ਕਰੋ",
        "labelLatitude": "ਅਕਸ਼ਾਂਸ਼",
        "labelLongitude": "ਦੇਸ਼ਾਂਤਰ",
        "btnAnalyze": "ਮੇਰੇ ਫਾਰਮ ਦਾ ਵਿਸ਼ਲੇਸ਼ਣ ਕਰੋ"
    },
    or: {
        // Navigation
        "navTitle": "ଅମୃତକୃଷି",
        "navFeatures": "ବ features ଶିଷ୍ଟ୍ୟଗୁଡିକ",
        "navLanguage": "ଭାଷା", 
        "navAbout": "ଆମ ବିଷୟରେ",
        
        // Location Page  
        "stepLocation": "ଅବସ୍ଥାନ",
        "stepAnalysis": "ବିଶ୍ଳେଷଣ",
        "stepResults": "ଫଳାଫଳ",
        "formTitle": "ଆପଣଙ୍କ ଫାର୍ମ ସ୍ଥାନ ପ୍ରବେଶ କରନ୍ତୁ",
        "formSubtitle": "ସର୍ବୋତ୍ତମ ଫସଲର ପରାମର୍ଶ ଦେବା ପାଇଁ ଆମେ ମୃତ୍ତିକା ଏବଂ ଜଳବାୟୁର ବିଶ୍ଳେଷଣ କରିବୁ",
        "labelName": "ଆପଣଙ୍କର ନାମ", 
        "labelMethod": "ଅବସ୍ଥାନ ପଦ୍ଧତି ଚୟନ କରନ୍ତୁ",
        "methodCurrent": "ବର୍ତ୍ତମାନର ଅବସ୍ଥାନ ବ୍ୟବହାର କରନ୍ତୁ",
        "methodMap": "ମାନଚିତ୍ରରେ ବାଛନ୍ତୁ",
        "methodManual": "ହାତେଇ ପ୍ରବେଶ କରନ୍ତୁ",
        "mapInstructions": "ଆପଣଙ୍କ ଫାର୍ମ ସ୍ଥାନରେ କ୍ଲିକ୍ କରନ୍ତୁ",
        "labelLatitude": "ଅକ୍ଷାଂଶ",
        "labelLongitude": "ଦ୍ରାଘିମା",
        "btnAnalyze": "ମୋର ଫାର୍ମ ବିଶ୍ଳେଷଣ କରନ୍ତୁ"
    }
};

const LANGUAGE_DISPLAY = {
    en: "English",
    hi: "हिंदी", 
    pa: "ਪੰਜਾਬੀ",
    or: "ଓଡ଼ିଆ"
};

// Global function to set language
function setAppLanguage(langCode) {
    console.log("🔧 SETTING LANGUAGE TO:", langCode);
    
    // Save to localStorage
    localStorage.setItem('preferredLanguage', langCode);
    
    // Update all elements with data-i18n attribute
    document.querySelectorAll('[data-i18n]').forEach(element => {
        const key = element.getAttribute('data-i18n');
        if (APP_TRANSLATIONS[langCode] && APP_TRANSLATIONS[langCode][key]) {
            element.textContent = APP_TRANSLATIONS[langCode][key];
            console.log("✅ Updated:", key, "->", APP_TRANSLATIONS[langCode][key]);
        }
    });
    
    // Update language display
    const langDisplay = document.getElementById('currentLangDisplay');
    if (langDisplay && LANGUAGE_DISPLAY[langCode]) {
        langDisplay.textContent = LANGUAGE_DISPLAY[langCode];
        console.log("✅ Updated language display to:", LANGUAGE_DISPLAY[langCode]);
    }
}

// Load language when page loads
function loadAppLanguage() {
    const savedLang = localStorage.getItem('preferredLanguage') || 'en';
    console.log("📖 LOADING SAVED LANGUAGE:", savedLang);
    setAppLanguage(savedLang);
    return savedLang;
}

// Initialize when page loads
document.addEventListener('DOMContentLoaded', function() {
    console.log("🚀 INITIALIZING SHARED LANGUAGE SYSTEM");
    loadAppLanguage();
});