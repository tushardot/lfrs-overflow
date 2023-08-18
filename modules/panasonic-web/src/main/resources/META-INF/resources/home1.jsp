<!DOCTYPE html>
<html>
<head>
    <title>Image Slideshow with Footer</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        .slideshow-container {
            position: relative;
            max-width: 100%;
            margin: auto;
        }

        .slide {
            display: none;
            width: 100%;
        }

        img {
            width: 100%;
            height: auto;
        }

        .footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px;
            position: absolute;
            bottom: 0;
            width: 100%;
        }

        .footer p {
            margin: 0;
        }
    </style>
</head>
<body>
    <div class="slideshow-container">
        <div class="slide">
            <img src="https://img.freepik.com/free-vector/security-concept-illustration_114360-497.jpg?w=996&t=st=1691660852~exp=1691661452~hmac=2942b1ce1052a1f2c0953db923236e22e2fc31a0b80da0187d235bfc363ccd12" alt="Slide 1">
        </div>
        <div class="slide">
            <img src="https://img.freepik.com/free-vector/completed-steps-concept-illustration_114360-5521.jpg?w=996&t=st=1691660879~exp=1691661479~hmac=440d183102e1a17f2e3b9f39234a6d01e643fb0d7a1529e3804dbd313096c5c9" alt="Slide 2">
        </div>
        <div class="slide">
            <img src="https://img.freepik.com/premium-vector/secure-login-sign-up-concept-illustration-user-use-secure-login-password-protection-website-social-media-account-vector-flat-style_7737-2270.jpg?w=1380" alt="Slide 3">
        </div>
    </div>
    <div class="slide">
            <img src="https://img.freepik.com/free-vector/key-concept-illustration_114360-6305.jpg?w=996&t=st=1691660953~exp=1691661553~hmac=9964a523e98265b283bf38660f33e9bf1c2a29db6cf8212aba624f16d6b3070f" alt="Slide 3">
        </div>
    </div>
    <div class="slide">
            <img src="https://img.freepik.com/free-vector/my-password-concept-illustration_114360-4294.jpg?w=996&t=st=1691660932~exp=1691661532~hmac=10441592d26a6991059c8611dc48bcd0526004cce26e46ec5c20357873d185a4" alt="Slide 3">
        </div>
    </div>

    <div class="footer">
        <p>&copy; <span id="currentYear"></span> All rights reserved.</p>
    </div>

    <script>
        let slideIndex = 0;
        showSlides();

        function showSlides() {
            let slides = document.getElementsByClassName("slide");
            for (let i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";
            }
            slideIndex++;
            if (slideIndex > slides.length) {
                slideIndex = 1;
            }
            slides[slideIndex - 1].style.display = "block";
            setTimeout(showSlides, 2000); // Change slide every 2 seconds
        }

        // Get the current year and update the footer
        let currentYear = new Date().getFullYear();
        document.getElementById("currentYear").textContent = currentYear;
    </script>
</body>
</html>
