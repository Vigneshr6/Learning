<html>
<head>
<title>Accordion</title>
    <link rel="stylesheet" href="lib/jquery-ui.css">
    <script src="lib/jquery-1.7.js"></script>
    <script src="lib/jquery-ui-1.12.1.js"></script>
    <script>
        $(function () {
            $(".accordion-target").accordion({
                active: false,
                collapsible: true
            });
        });
    </script>
    <style>
        .my-accordion-content {
            height: auto !important;
        }
    </style>
</head>
<body>
    <div class="accordion-target">
        <h3>Section 1</h3>
        <div class="accordion-target">
            <div id="inneraccordion">
                <h3>Section 4</h3>
                <div class="my-accordion-content">
                    <p>
                        Cras dictum. Pellentesque habitant morbi tristique senectus et netus
                        et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in
                        faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia
                        mauris vel est.
                    </p>
                    <p>
                        Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus.
                        Class aptent taciti sociosqu ad litora torquent per conubia nostra, per
                        inceptos himenaeos.
                    </p>
                </div>
            </div>
        </div>
        <h3>Section 2</h3>
        <div class="my-accordion-content">
            <p>
                Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet
                purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor
                velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In
                suscipit faucibus urna.
            </p>
        </div>
        <h3>Section 3</h3>
        <div class="my-accordion-content">
            <p>
                Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis.
                Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero
                ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis
                lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.
            </p>
            <ul>
                <li>List item one</li>
                <li>List item two</li>
                <li>List item three</li>
            </ul>
        </div>
    </div>
</body>
</html>