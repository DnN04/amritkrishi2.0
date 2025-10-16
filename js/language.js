// Landing page language functions
const LANDING_TRANSLATIONS = {
    en: {
        tagline: "Revolutionizing Agriculture with Smart Technology",
        title: "AmritKrishi", 
        subtitle: "A smart revolutionary tech solution to enhance our agriculture with traditional wisdom",
        getStarted: "Get Started in"
    },
    hi: {
        tagline: "स्मार्ट तकनीक के साथ कृषि क्रांति",
        title: "अमृतकृषि",
        subtitle: "पारंपरिक ज्ञान के साथ हमारी कृषि को बढ़ाने के लिए एक स्मार्ट क्रांतिकारी तकनीक समाधान",
        getStarted: "शुरू करें"
    },
    pa: {
        tagline: "ਸਮਾਰਟ ਟੈਕਨਾਲੋਜੀ ਨਾਲ ਖੇਤੀ ਵਿੱਚ ਕ੍ਰਾਂਤੀ",
        title: "ਅੰਮ੍ਰਿਤ ਕ੍ਰਿਸ਼ੀ",
        subtitle: "ਸਾਡੀ ਖੇਤੀ ਨੂੰ ਬਿਹਤਰ ਬਣਾਉਣ ਲਈ ਇੱਕ ਸਮਾਰਟ ਕ੍ਰਾਂਤੀਕਾਰੀ ਟੈਕਨਾਲੋਜੀ ਹੱਲ",
        getStarted: "ਸ਼ੁਰੂ ਕਰੋ"
    },
    or: {
        tagline: "ସ୍ମାର୍ଟ ଟେକ୍ନୋଲୋଜି ସହିତ କୃଷିରେ ବିପ୍ଳବ",
        title: "ଅମୃତକୃଷି", 
        subtitle: "ଆମର କୃଷି ବ enhance ାଇବା ପାଇଁ ଏକ ସ୍ମାର୍ଟ ବିପ୍ଳବୀ ଟେକ୍ ସମାଧାନ",
        getStarted: "ଆରମ୍ଭ କରନ୍ତୁ"
    }
};

const languages = ['English', 'हिंदी', 'ਪੰਜਾਬੀ', 'ଓଡ଼ିଆ'];
let currentLangIndex = 0;
let isDropdownOpen = false;

// Language selection function
function selectLanguage(langCode) {
    console.log("🎯 LANGUAGE SELECTED:", langCode);
    
    // Update landing page text immediately
    if (LANDING_TRANSLATIONS[langCode]) {
        document.getElementById('taglineText').textContent = LANDING_TRANSLATIONS[langCode].tagline;
        document.getElementById('mainTitle').textContent = LANDING_TRANSLATIONS[langCode].title;
        document.getElementById('subtitleText').textContent = LANDING_TRANSLATIONS[langCode].subtitle;
        document.getElementById('getStartedText').textContent = LANDING_TRANSLATIONS[langCode].getStarted;
    }
    
    document.getElementById('currentLanguage').textContent = languages[getLangIndex(langCode)];
    
    // Save to shared system
    setAppLanguage(langCode);
    
    closeDropdown();
    
    // Redirect to location page
    setTimeout(() => {
        console.log("🔄 REDIRECTING TO LOCATION PAGE");
        window.location.href = 'location.html';
    }, 500);
}

function getLangIndex(langCode) {
    const codes = ['en', 'hi', 'pa', 'or'];
    return codes.indexOf(langCode);
}

function toggleDropdown() {
    isDropdownOpen = !isDropdownOpen;
    const dropdown = document.getElementById('dropdownMenu');
    const arrow = document.querySelector('.dropdown-arrow');
    
    if (isDropdownOpen) {
        dropdown.style.display = 'block';
        arrow.style.transform = 'rotate(180deg)';
    } else {
        dropdown.style.display = 'none';
        arrow.style.transform = 'rotate(0deg)';
    }
}

function closeDropdown() {
    isDropdownOpen = false;
    document.getElementById('dropdownMenu').style.display = 'none';
    document.querySelector('.dropdown-arrow').style.transform = 'rotate(0deg)';
}

function startLanguageScroll() {
    setInterval(() => {
        if (!isDropdownOpen) {
            currentLangIndex = (currentLangIndex + 1) % languages.length;
            document.getElementById('currentLanguage').textContent = languages[currentLangIndex];
        }
    }, 2000);
}

// Initialize landing page
document.addEventListener('DOMContentLoaded', function() {
    console.log("🏠 LANDING PAGE LOADED");
    
    // Set up dropdown button
    document.getElementById('languageBtn').addEventListener('click', function(e) {
        e.stopPropagation();
        toggleDropdown();
    });
    
    // Close dropdown when clicking outside
    document.addEventListener('click', function() {
        closeDropdown();
    });
    
    // Add event listeners to dropdown items
    document.querySelectorAll('.dropdown-item').forEach(item => {
        item.addEventListener('click', function() {
            const langCode = this.getAttribute('data-lang');
            selectLanguage(langCode);
        });
    });
    
    // Start auto-scroll
    startLanguageScroll();
    
    // Show title with animation
    setTimeout(() => {
        document.querySelector('.title-container').style.opacity = '1';
    }, 500);
});

// Prevent dropdown close when clicking inside dropdown
document.getElementById('dropdownMenu').addEventListener('click', function(e) {
    e.stopPropagation();
});