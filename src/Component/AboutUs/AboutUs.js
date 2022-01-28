import TreDLogo from '../../assets/TredeciverseLogo.png';
import ComingSoon from '../../assets/ComingSoon.gif';
import S7Image from '../../assets/7SImage.png';

function AboutUs() {

    return(
        <div className="w3-content" style={{'maxWidth': '1200px'}}>
            <div className="w3-panel">
                <i className="w3-xlarge fa fa-bars"></i>
            </div>
            {/* First Grid: Logo & About */}
            <div className="w3-row">
                <div className="w3-half w3-container">
                    <h1 className="w3-xxlarge w3-text-light-grey">Hello</h1>
                    <h1 className="w3-xxlarge w3-text-grey">We are</h1>
                    <h1 className="w3-jumbo">Tredeciverse Studios</h1>
                    <img src={TreDLogo} className="about-display" />
                </div>
                <div className="w3-half w3-container w3-xlarge w3-text-grey">
                    <p></p>
                    <p className="">We build new worlds and explore places that you've never imagined before.</p>
                    <p>Tredeciverse <b>IS</b> creativity.</p>
                </div>
            </div>
            {/* Second Grid: Resent */}
            <div className="w3-panel w3-text-grey">
                <h1>MOST RECENT WORK</h1>
            </div>
            <div className="w3-row">
                <div className="w3-half w3-container">
                    <h4>Janken Fighter Alpha</h4>
                    <img src={ComingSoon} className="about-display" />
                </div>
            </div>
            <div className="w3-row">
                <div className="w3-half w3-container">
                    <h4>7 Sectors</h4> 
                    <img src={S7Image} className="about-display" />
                    <p className="w3-xlarge w3-text-grey">The fun and exciting Space Escape game!</p>
                </div>
            </div>
            <div className="credits">
                <p>Fist Icon provided by <a href="https://www.vecteezy.com/free-vector/clenched-fist">Clenched Fist Vectors by Vecteezy</a>.</p>
                <p>Intelligence Icon provided by <a href="https://www.vecteezy.com/free-vector/brain-icon">Brain Icon Vectors by Vecteezy</a>.</p>
                <p>Spirit Icon provided by <a href="https://clker.com/clipart-maron-flame-logo-5-6.html"></a>Free Clipart by Prizie</p>
                <p>Thunder Cloud Icon provided by <a href="flaticons.net/cusomize.php?dir=Mobile%20Application&icon=Cloud-Thunder.png">Flaticons</a></p>
                <p>Sword and Shield icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></p>
                <p>Avatar images provided by <a href="https://www.fiverr.com/vanvan98">vanvan98</a>.</p>
                <p>Other graphics provided by Jackie Jacks.</p>
                <p>Site template provided by <a href="https://getbootstrap.com/docs/5.0/forms/layout/">GetBootstrap</a>.</p>
            </div>
        </div>
    );
}
export default AboutUs;