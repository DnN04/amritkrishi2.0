// SHARED LANGUAGE SYSTEM - Include this in EVERY page
console.log("=== SHARED LANGUAGE SYSTEM LOADED ===");

// Global translations
const APP_TRANSLATIONS = {
    // en: {
    //     // Navigation
    //     "navTitle": "AmritKrishi",
    //     "navFeatures": "Features",
    //     "navLanguage": "Language", 
    //     "navAbout": "About",
        
    //     // Location Page
    //     "stepLocation": "Location",
    //     "stepAnalysis": "Analysis",
    //     "stepResults": "Results",
    //     "formTitle": "Enter Your Farm Location",
    //     "formSubtitle": "We'll analyze soil and climate to recommend the best crops",
    //     "labelName": "Your Name",
    //     "labelMethod": "Choose Location Method",
    //     "methodCurrent": "Use Current Location",
    //     "methodMap": "Pick on Map", 
    //     "methodManual": "Enter Manually",
    //     "mapInstructions": "Click on your farm location",
    //     "labelLatitude": "Latitude",
    //     "labelLongitude": "Longitude",
    //     "btnAnalyze": "Analyze My Farm"
    // },
    // hi: {
    //     // Navigation
    //     "navTitle": "अमृतकृषि",
    //     "navFeatures": "विशेषताएं",
    //     "navLanguage": "भाषा",
    //     "navAbout": "हमारे बारे में",
        
    //     // Location Page
    //     "stepLocation": "स्थान",
    //     "stepAnalysis": "विश्लेषण", 
    //     "stepResults": "परिणाम",
    //     "formTitle": "अपना फार्म स्थान दर्ज करें",
    //     "formSubtitle": "हम सबसे अच्छी फसलों की सिफारिश करने के लिए मिट्टी और जलवायु का विश्लेषण करेंगे",
    //     "labelName": "आपका नाम",
    //     "labelMethod": "स्थान विधि चुनें",
    //     "methodCurrent": "वर्तमान स्थान का उपयोग करें",
    //     "methodMap": "मानचित्र पर चुनें",
    //     "methodManual": "मैन्युअल रूप से दर्ज करें",
    //     "mapInstructions": "अपने फार्म के स्थान पर क्लिक करें",
    //     "labelLatitude": "अक्षांश",
    //     "labelLongitude": "देशांतर", 
    //     "btnAnalyze": "मेरे फार्म का विश्लेषण करें"
    // },
    // pa: {
    //     // Navigation
    //     "navTitle": "ਅੰਮ੍ਰਿਤ ਕ੍ਰਿਸ਼ੀ",
    //     "navFeatures": "ਵਿਸ਼ੇਸ਼ਤਾਵਾਂ", 
    //     "navLanguage": "ਭਾਸ਼ਾ",
    //     "navAbout": "ਸਾਡੇ ਬਾਰੇ",
        
    //     // Location Page
    //     "stepLocation": "ਟਿਕਾਣਾ",
    //     "stepAnalysis": "ਵਿਸ਼ਲੇਸ਼ਣ",
    //     "stepResults": "ਨਤੀਜੇ", 
    //     "formTitle": "ਆਪਣਾ ਫਾਰਮ ਟਿਕਾਣਾ ਦਰਜ ਕਰੋ",
    //     "formSubtitle": "ਅਸੀਂ ਸਭ ਤੋਂ ਵਧੀਆ ਫਸਲਾਂ ਦੀ ਸਿਫਾਰਸ਼ ਕਰਨ ਲਈ ਮਿੱਟੀ ਅਤੇ ਜਲਵਾਯੂ ਦਾ ਵਿਸ਼ਲੇਸ਼ਣ ਕਰਾਂਗੇ",
    //     "labelName": "ਤੁਹਾਡਾ ਨਾਮ",
    //     "labelMethod": "ਟਿਕਾਣਾ ਵਿਧੀ ਚੁਣੋ",
    //     "methodCurrent": "ਮੌਜੂਦਾ ਟਿਕਾਣਾ ਵਰਤੋਂ",
    //     "methodMap": "ਨਕਸ਼ੇ 'ਤੇ ਚੁਣੋ",
    //     "methodManual": "ਖੁਦ ਦਰਜ ਕਰੋ", 
    //     "mapInstructions": "ਆਪਣੇ ਫਾਰਮ ਦੇ ਟਿਕਾਣੇ 'ਤੇ ਕਲਿਕ ਕਰੋ",
    //     "labelLatitude": "ਅਕਸ਼ਾਂਸ਼",
    //     "labelLongitude": "ਦੇਸ਼ਾਂਤਰ",
    //     "btnAnalyze": "ਮੇਰੇ ਫਾਰਮ ਦਾ ਵਿਸ਼ਲੇਸ਼ਣ ਕਰੋ"
    // },
    // or: {
    //     // Navigation
    //     "navTitle": "ଅମୃତକୃଷି",
    //     "navFeatures": "ବ features ଶିଷ୍ଟ୍ୟଗୁଡିକ",
    //     "navLanguage": "ଭାଷା", 
    //     "navAbout": "ଆମ ବିଷୟରେ",
        
    //     // Location Page  
    //     "stepLocation": "ଅବସ୍ଥାନ",
    //     "stepAnalysis": "ବିଶ୍ଳେଷଣ",
    //     "stepResults": "ଫଳାଫଳ",
    //     "formTitle": "ଆପଣଙ୍କ ଫାର୍ମ ସ୍ଥାନ ପ୍ରବେଶ କରନ୍ତୁ",
    //     "formSubtitle": "ସର୍ବୋତ୍ତମ ଫସଲର ପରାମର୍ଶ ଦେବା ପାଇଁ ଆମେ ମୃତ୍ତିକା ଏବଂ ଜଳବାୟୁର ବିଶ୍ଳେଷଣ କରିବୁ",
    //     "labelName": "ଆପଣଙ୍କର ନାମ", 
    //     "labelMethod": "ଅବସ୍ଥାନ ପଦ୍ଧତି ଚୟନ କରନ୍ତୁ",
    //     "methodCurrent": "ବର୍ତ୍ତମାନର ଅବସ୍ଥାନ ବ୍ୟବହାର କରନ୍ତୁ",
    //     "methodMap": "ମାନଚିତ୍ରରେ ବାଛନ୍ତୁ",
    //     "methodManual": "ହାତେଇ ପ୍ରବେଶ କରନ୍ତୁ",
    //     "mapInstructions": "ଆପଣଙ୍କ ଫାର୍ମ ସ୍ଥାନରେ କ୍ଲିକ୍ କରନ୍ତୁ",
    //     "labelLatitude": "ଅକ୍ଷାଂଶ",
    //     "labelLongitude": "ଦ୍ରାଘିମା",
    //     "btnAnalyze": "ମୋର ଫାର୍ମ ବିଶ୍ଳେଷଣ କରନ୍ତୁ"
    // }


    //new
    // SHARED LANGUAGE SYSTEM - Include this in EVERY page
    en: {
        // Navigation
        "navTitle": "AmritKrishi",
        "navFeatures": "Features",
        "navLanguage": "Language", 
        "navAbout": "About",
        "navHome": "Home",
        "navLocation": "Location", 
        "navResults": "Results",
        
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
        "btnAnalyze": "Analyze My Farm",
        
        // Results Page
        "welcome": "Hello",
        "locationAnalysis": "Location Analysis",
        "soilType": "Soil Type",
        "climateZone": "Climate Zone",
        "topRecommendations": "Top Crop Recommendations",
        "detailedAnalysis": "Detailed Analysis",
        "soilAnalysis": "Soil Analysis",
        "climateData": "Climate Data",
        "seasonalCalendar": "Seasonal Calendar",
        "analyzeAnother": "Analyze Another Location",
        "saveRecommendations": "Save Recommendations",
        "shareResults": "Share Results"
    },
    hi: {
        // Navigation
        "navTitle": "अमृतकृषि",
        "navFeatures": "विशेषताएं",
        "navLanguage": "भाषा",
        "navAbout": "हमारे बारे में",
        "navHome": "होम",
        "navLocation": "स्थान",
        "navResults": "परिणाम",
        
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
        "btnAnalyze": "मेरे फार्म का विश्लेषण करें",
        
        // Results Page
        "welcome": "नमस्ते",
        "locationAnalysis": "स्थान विश्लेषण",
        "soilType": "मिट्टी का प्रकार",
        "climateZone": "जलवायु क्षेत्र",
        "topRecommendations": "शीर्ष फसल सिफारिशें",
        "detailedAnalysis": "विस्तृत विश्लेषण",
        "soilAnalysis": "मिट्टी विश्लेषण",
        "climateData": "जलवायु डेटा",
        "seasonalCalendar": "मौसमी कैलेंडर",
        "analyzeAnother": "दूसरा स्थान विश्लेषण करें",
        "saveRecommendations": "सिफारिशें सहेजें",
        "shareResults": "परिणाम साझा करें"
    },
    pa: {
        // Navigation
        "navTitle": "ਅੰਮ੍ਰਿਤ ਕ੍ਰਿਸ਼ੀ",
        "navFeatures": "ਵਿਸ਼ੇਸ਼ਤਾਵਾਂ", 
        "navLanguage": "ਭਾਸ਼ਾ",
        "navAbout": "ਸਾਡੇ ਬਾਰੇ",
        "navHome": "ਘਰ",
        "navLocation": "ਟਿਕਾਣਾ",
        "navResults": "ਨਤੀਜੇ",
        
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
        "btnAnalyze": "ਮੇਰੇ ਫਾਰਮ ਦਾ ਵਿਸ਼ਲੇਸ਼ਣ ਕਰੋ",
        
        // Results Page
        "welcome": "ਸਤ ਸ੍ਰੀ ਅਕਾਲ",
        "locationAnalysis": "ਟਿਕਾਣਾ ਵਿਸ਼ਲੇਸ਼ਣ",
        "soilType": "ਮਿੱਟੀ ਦੀ ਕਿਸਮ",
        "climateZone": "ਜਲਵਾਯੂ ਜ਼ੋਨ",
        "topRecommendations": "ਚੋਟੀ ਦੀਆਂ ਫਸਲ ਸਿਫਾਰਸ਼ਾਂ",
        "detailedAnalysis": "ਵਿਸਤ੍ਰਿਤ ਵਿਸ਼ਲੇਸ਼ਣ",
        "soilAnalysis": "ਮਿੱਟੀ ਵਿਸ਼ਲੇਸ਼ਣ",
        "climateData": "ਜਲਵਾਯੂ ਡੇਟਾ",
        "seasonalCalendar": "ਮੌਸਮੀ ਕੈਲੰਡਰ",
        "analyzeAnother": "ਕੋਈ ਹੋਰ ਟਿਕਾਣਾ ਵਿਸ਼ਲੇਸ਼ਣ ਕਰੋ",
        "saveRecommendations": "ਸਿਫਾਰਸ਼ਾਂ ਸੰਭਾਲੋ",
        "shareResults": "ਨਤੀਜੇ ਸਾਂਝੇ ਕਰੋ"
    },
    or: {
        // Navigation
        "navTitle": "ଅମୃତକୃଷି",
        "navFeatures": "ବ features ଶିଷ୍ଟ୍ୟଗୁଡିକ",
        "navLanguage": "ଭାଷା", 
        "navAbout": "ଆମ ବିଷୟରେ",
        "navHome": "ହୋମ୍",
        "navLocation": "ଅବସ୍ଥାନ",
        "navResults": "ଫଳାଫଳ",
        
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
        "btnAnalyze": "ମୋର ଫାର୍ମ ବିଶ୍ଳେଷଣ କରନ୍ତୁ",
        
        // Results Page
        "welcome": "ନମସ୍କାର",
        "locationAnalysis": "ଅବସ୍ଥାନ ବିଶ୍ଳେଷଣ",
        "soilType": "ମୃତ୍ତିକା ପ୍ରକାର",
        "climateZone": "ଜଳବାୟୁ ଜୋନ୍",
        "topRecommendations": "ଶୀର୍ଷ ଫସଲ ପରାମର୍ଶ",
        "detailedAnalysis": "ବିସ୍ତୃତ ବିଶ୍ଳେଷଣ",
        "soilAnalysis": "ମୃତ୍ତିକା ବିଶ୍ଳେଷଣ",
        "climateData": "ଜଳବାୟୁ ତଥ୍ୟ",
        "seasonalCalendar": "ଋତୁକାଳୀନ କ୍ୟାଲେଣ୍ଡର",
        "analyzeAnother": "ଅନ୍ୟ ଅବସ୍ଥାନ ବିଶ୍ଳେଷଣ କରନ୍ତୁ",
        "saveRecommendations": "ପରାମର୍ଶଗୁଡିକ ସେଭ୍ କରନ୍ତୁ",
        "shareResults": "ଫଳାଫଳ ଅଂଶୀଦାର କରନ୍ତୁ"
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
    
    // Update language dropdown if exists
    const langSelect = document.getElementById('languageSelect');
    if (langSelect) {
        langSelect.value = langCode;
    }
}

// Load language when page loads
function loadAppLanguage() {
    const savedLang = localStorage.getItem('preferredLanguage') || 'en';
    console.log("📖 LOADING SAVED LANGUAGE:", savedLang);
    setAppLanguage(savedLang);
    return savedLang;
}

// Function to create language dropdown
function createLanguageDropdown() {
    const langDisplay = document.getElementById('currentLangDisplay');
    if (!langDisplay) return;
    
    // Create dropdown container
    const dropdownContainer = document.createElement('div');
    dropdownContainer.className = 'language-dropdown-container';
    dropdownContainer.style.position = 'relative';
    dropdownContainer.style.display = 'inline-block';
    
    // Replace the current display with dropdown
    const parent = langDisplay.parentNode;
    parent.removeChild(langDisplay);
    
    // Create dropdown button
    const dropdownButton = document.createElement('button');
    dropdownButton.className = 'language-dropdown-btn';
    dropdownButton.innerHTML = `
        <span class="current-language">${LANGUAGE_DISPLAY[loadAppLanguage()]}</span>
        <span class="dropdown-arrow">▼</span>
    `;
    
    // Create dropdown menu
    const dropdownMenu = document.createElement('div');
    dropdownMenu.className = 'language-dropdown-menu';
    dropdownMenu.style.display = 'none';
    
    // Add language options
    Object.entries(LANGUAGE_DISPLAY).forEach(([code, name]) => {
        const option = document.createElement('div');
        option.className = 'language-option';
        option.textContent = name;
        option.onclick = () => {
            setAppLanguage(code);
            dropdownMenu.style.display = 'none';
            dropdownButton.innerHTML = `
                <span class="current-language">${name}</span>
                <span class="dropdown-arrow">▼</span>
            `;
        };
        dropdownMenu.appendChild(option);
    });
    
    // Add click event to toggle dropdown
    dropdownButton.onclick = (e) => {
        e.stopPropagation();
        dropdownMenu.style.display = dropdownMenu.style.display === 'none' ? 'block' : 'none';
    };
    
    // Close dropdown when clicking outside
    document.addEventListener('click', () => {
        dropdownMenu.style.display = 'none';
    });
    
    dropdownContainer.appendChild(dropdownButton);
    dropdownContainer.appendChild(dropdownMenu);
    parent.appendChild(dropdownContainer);
}

// Initialize when page loads
document.addEventListener('DOMContentLoaded', function() {
    console.log("🚀 INITIALIZING SHARED LANGUAGE SYSTEM");
    loadAppLanguage();
    createLanguageDropdown();
});
    
// };

// const LANGUAGE_DISPLAY = {
//     en: "English",
//     hi: "हिंदी", 
//     pa: "ਪੰਜਾਬੀ",
//     or: "ଓଡ଼ିଆ"
// };

// // Global function to set language
// function setAppLanguage(langCode) {
//     console.log("🔧 SETTING LANGUAGE TO:", langCode);
    
//     // Save to localStorage
//     localStorage.setItem('preferredLanguage', langCode);
    
//     // Update all elements with data-i18n attribute
//     document.querySelectorAll('[data-i18n]').forEach(element => {
//         const key = element.getAttribute('data-i18n');
//         if (APP_TRANSLATIONS[langCode] && APP_TRANSLATIONS[langCode][key]) {
//             element.textContent = APP_TRANSLATIONS[langCode][key];
//             console.log("✅ Updated:", key, "->", APP_TRANSLATIONS[langCode][key]);
//         }
//     });
    
//     // Update language display
//     const langDisplay = document.getElementById('currentLangDisplay');
//     if (langDisplay && LANGUAGE_DISPLAY[langCode]) {
//         langDisplay.textContent = LANGUAGE_DISPLAY[langCode];
//         console.log("✅ Updated language display to:", LANGUAGE_DISPLAY[langCode]);
//     }
// }

// // Load language when page loads
// function loadAppLanguage() {
//     const savedLang = localStorage.getItem('preferredLanguage') || 'en';
//     console.log("📖 LOADING SAVED LANGUAGE:", savedLang);
//     setAppLanguage(savedLang);
//     return savedLang;
// }

// // Initialize when page loads
// document.addEventListener('DOMContentLoaded', function() {
//     console.log("🚀 INITIALIZING SHARED LANGUAGE SYSTEM");
//     loadAppLanguage();
// });
// Add this function to handle the select dropdown
function setupLanguageSelect() {
    const langSelect = document.getElementById('languageSelect');
    if (langSelect) {
        // Set current language
        const currentLang = loadAppLanguage();
        langSelect.value = currentLang;
        
        // Add change event
        langSelect.addEventListener('change', function() {
            setAppLanguage(this.value);
        });
    }
}

// Update the DOMContentLoaded event:
document.addEventListener('DOMContentLoaded', function() {
    console.log("🚀 INITIALIZING SHARED LANGUAGE SYSTEM");
    loadAppLanguage();
    setupLanguageSelect(); // Use this instead of createLanguageDropdown()
});