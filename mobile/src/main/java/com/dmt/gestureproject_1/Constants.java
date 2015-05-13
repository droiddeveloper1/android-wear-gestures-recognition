/*
 * Copyright (c) 2014-2015, Oke Uwechue. All Rights Reserved.
 *
 * This file is part of Android Wear Gesture Recognizer.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dmt.gestureproject_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Defines various global constants
 *
 *  Elliptic Fourier Descriptors are here defined as a set of the first 8 harmonics
 *  e.g.
         add(new ArrayList<Double>(Arrays.asList(w,x,y,z)));    -- 1st harmonic (lowest frequency characteristics)
         add(new ArrayList<Double>(Arrays.asList(w,x,y,z)));    -- 2nd harmonic
         add(new ArrayList<Double>(Arrays.asList(w,x,y,z)));    -- 3rd harmonic
         add(new ArrayList<Double>(Arrays.asList(w,x,y,z)));    -- 4th harmonic
         add(new ArrayList<Double>(Arrays.asList(w,x,y,z)));    -- 5th harmonic
         add(new ArrayList<Double>(Arrays.asList(w,x,y,z)));    -- 6th harmonic
         add(new ArrayList<Double>(Arrays.asList(w,x,y,z)));    -- 7th harmonic
         add(new ArrayList<Double>(Arrays.asList(w,x,y,z)));    -- 8th harmonic  (highest frequency characteristics)

 */
public class Constants {

    private Constants() {
    }

    public enum SHAPE_TYPE {CIRCLE, SQUARE, TRIANGLE, VEE, LINE, UNKNOWN};

    // hardcoded CIRCLE descriptors obtained by experimentation
    //
    public static final List<List<List<Double>>> DESCRIPTORS_CIRCLE = new ArrayList<List<List<Double>>>() {{

        // add sets of 8 EFD harmonics
        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(1.3322676295501878E-15,-5.551115123125783E-16,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(8.72514835103026,1.1451359141006143,-1.2484512154669805,7.315989599691949)));
            add(new ArrayList<Double>(Arrays.asList(-1.8745423235798118,-0.10208033216964946,1.121181754762878,0.389017110397957)));
            add(new ArrayList<Double>(Arrays.asList(-0.5129418839855899,0.4585571922649194,-1.1568967164233133,0.5136211402097243)));
            add(new ArrayList<Double>(Arrays.asList(0.14642310765493033,0.2178463234094794,-0.4561947356116559,0.34473276815015574)));
            add(new ArrayList<Double>(Arrays.asList(-0.45595594507552395,0.3158887219524633,0.35545002933120906,0.5166989960873123)));
            add(new ArrayList<Double>(Arrays.asList(-0.3998122614033572,-0.01792476704190149,0.6001524206138865,-0.17718590109447613)));
            add(new ArrayList<Double>(Arrays.asList(-0.6931004063812394,0.4983298976968456,-0.8411289558697053,0.043329883861596225)));
        }});


        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-3.343730521224001E-15,0.0,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(14.70343257923065,2.5049171099581886,3.772216557299181,-12.070560814040036)));
            add(new ArrayList<Double>(Arrays.asList(1.9499085784986179,0.8901907998253207,-2.508151628293912,-3.609898255541748)));
            add(new ArrayList<Double>(Arrays.asList(-1.7952055987080282,0.4087011628318573,-0.5383646564502117,-1.690979089984524)));
            add(new ArrayList<Double>(Arrays.asList(-1.589755522395878,0.012216621103948904,1.4850424545475558,-1.0811020871457953)));
            add(new ArrayList<Double>(Arrays.asList(-0.6915463615409533,0.03716647919421224,-0.06286457421502376,-0.09906201553801874)));
            add(new ArrayList<Double>(Arrays.asList(0.9978605156608527,-1.4063431372748127,-0.7891102745475483,-0.6181868104171068)));
            add(new ArrayList<Double>(Arrays.asList(0.23180334384460072,-0.7087970678958263,-1.714841731230386,0.3510082039587097)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(7.47939721852737E-16,-2.243819165558211E-15,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(12.112860992636818,-2.5960912283941977,4.062540244044866,7.559541336906653)));
            add(new ArrayList<Double>(Arrays.asList(1.4121493874347961,-0.2159607102070686,0.20979852033669313,1.5399442252843307)));
            add(new ArrayList<Double>(Arrays.asList(0.5767747373705575,0.36548550116525325,-0.1822400941295814,-0.03129301132827948)));
            add(new ArrayList<Double>(Arrays.asList(0.2238564686627341,0.7512141385431974,-0.9146296964932514,-0.3223657391567119)));
            add(new ArrayList<Double>(Arrays.asList(-0.31898534737590445,0.7327509060863615,-1.195220767798632,-0.18771253905693278)));
            add(new ArrayList<Double>(Arrays.asList(-0.1356598075996209,0.7443538543627433,-0.322258160084085,-0.09935660784735807)));
            add(new ArrayList<Double>(Arrays.asList(-0.3826620108099601,0.09229227315207042,-0.1877623573436118,0.18233397298683648)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-1.3816108750890835E-15,5.921189464667501E-16,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(13.723337646114402,-3.5824253498641956,-8.154068397576294,-7.435132948786333)));
            add(new ArrayList<Double>(Arrays.asList(-1.6310368171870417,1.66103549906479,4.4989858791711,-0.1667322645579642)));
            add(new ArrayList<Double>(Arrays.asList(-2.091675885233641,0.7551578131979663,-1.868688659787717,0.529020889671292)));
            add(new ArrayList<Double>(Arrays.asList(-0.3405036755350096,-0.5539484537704829,0.17976774557863054,0.9186054243934949)));
            add(new ArrayList<Double>(Arrays.asList(-0.6633895549732934,0.6657914943632434,0.6777383892443147,-0.8206947470268944)));
            add(new ArrayList<Double>(Arrays.asList(-2.009231051945177,1.377322653193576,-1.024969480760836,0.5148454505337308)));
            add(new ArrayList<Double>(Arrays.asList(-0.3737345036429471,0.42679275425201485,-0.3112337771211317,-0.05737037709593891)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-1.9737298215558337E-16,-3.9474596431116675E-16,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(9.76953639054601,6.643464700426341,7.779946248552813,-8.050243872751544)));
            add(new ArrayList<Double>(Arrays.asList(-1.7134224937881264,-0.051781555735849805,0.6462767054775669,1.2086854060101682)));
            add(new ArrayList<Double>(Arrays.asList(-0.5778199081571351,0.5473142254261425,1.7548473651944596,-0.5244291675227493)));
            add(new ArrayList<Double>(Arrays.asList(0.789977848587974,-0.46053637345233767,0.24654358478557106,-0.15306650246667036)));
            add(new ArrayList<Double>(Arrays.asList(0.06374213916251302,0.2193616580227712,0.04566659628133444,0.0931400658286863)));
            add(new ArrayList<Double>(Arrays.asList(-0.11359094972384877,-0.7057164503447018,1.4692285338371418,-1.1707709386162917)));
            add(new ArrayList<Double>(Arrays.asList(0.44598614857968677,0.19968089745292752,0.274133846345399,-0.1865813626007459)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(2.6177890264845795E-15,-1.495879443705474E-15,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(13.168048177372587,1.3088445528492907,-2.730390134853589,7.572164154897704)));
            add(new ArrayList<Double>(Arrays.asList(1.5767634863880227,2.7676638488967558,-1.9787632264138435,1.6982669121168479)));
            add(new ArrayList<Double>(Arrays.asList(0.8197841454671787,1.1152264625369133,1.2829754103172322,0.8602823007995064)));
            add(new ArrayList<Double>(Arrays.asList(0.7015042638577911,1.1014980158810834,1.1788848147747255,0.33824519986918367)));
            add(new ArrayList<Double>(Arrays.asList(-0.6463708552381913,0.5846893318113391,0.2045076378149294,0.6547083021929451)));
            add(new ArrayList<Double>(Arrays.asList(-0.9967314957380152,0.5843394490680353,-0.18812723989106633,0.16033134658161077)));
            add(new ArrayList<Double>(Arrays.asList(-0.46991153268006924,0.2512820918755556,-0.268996836297517,-0.1631211082130803)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-5.921189464667501E-15,5.921189464667501E-16,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(2.061821716290805,7.944409644732657,-14.585444255977395,1.0898269167088532)));
            add(new ArrayList<Double>(Arrays.asList(2.441617130571946,0.43183092207219465,-1.1096284019294829,3.38990738591131)));
            add(new ArrayList<Double>(Arrays.asList(-1.5765451482096715,-0.5206452274022859,-0.4018974149375908,-0.8244259002778644)));
            add(new ArrayList<Double>(Arrays.asList(-0.5536533431453683,1.599478081110935,-1.310481030127714,-0.1083787127714497)));
            add(new ArrayList<Double>(Arrays.asList(-1.4967748696113787,-0.38502785734818995,0.48716170699504224,1.229572381138825)));
            add(new ArrayList<Double>(Arrays.asList(-2.058265956014549,0.03763477820040497,-1.1039275282937866,-0.3729392594406607)));
            add(new ArrayList<Double>(Arrays.asList(-0.4631642622917083,0.4478692921345757,-0.1807022274590442,0.5426326932770664)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-9.868649107779169E-17,-4.934324553889585E-16,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(-7.7802766607602,1.6081639133760597,-1.395841482415632,-6.891334660091436)));
            add(new ArrayList<Double>(Arrays.asList(1.7972051387622907,0.7469674328970262,-2.7624178879666923,-0.5368641359419062)));
            add(new ArrayList<Double>(Arrays.asList(0.7520511876329491,0.4273811779831303,0.4749902709666861,0.07464560086825875)));
            add(new ArrayList<Double>(Arrays.asList(-0.47296119689243876,-0.06039868123441393,0.795196684316526,-0.1751981090251535)));
            add(new ArrayList<Double>(Arrays.asList(0.9055825094149449,-0.0030791912875388996,-0.01874106510793706,-0.023760104621128184)));
            add(new ArrayList<Double>(Arrays.asList(0.1718186087533656,0.4489956715735387,0.3938303919256051,0.664472918533086)));
            add(new ArrayList<Double>(Arrays.asList(0.10271693923591337,-0.5371169074152942,0.7907767115113832,0.07456687999250247)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(0.0,1.4802973661668753E-15,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(10.183215557161613,-0.21720863794539763,-0.08507422415797035,-6.748635973616483)));
            add(new ArrayList<Double>(Arrays.asList(0.35794089567350507,-0.0644199664729625,0.8047519099019596,-0.07392437694911821)));
            add(new ArrayList<Double>(Arrays.asList(-1.1259918573775705,-0.9822730612309056,-0.35416012225164084,-0.20386008275468093)));
            add(new ArrayList<Double>(Arrays.asList(0.22662188738829048,0.11921541990568629,-0.6045022697961152,-0.47949488747727936)));
            add(new ArrayList<Double>(Arrays.asList(0.13707637895689329,-0.25870906856061654,-0.552520227502254,-0.6454163316750298)));
            add(new ArrayList<Double>(Arrays.asList(-0.47141625737443,0.37770376690473934,-0.3327211049577416,0.08286565133190492)));
            add(new ArrayList<Double>(Arrays.asList(-0.8802650273323179,-0.24194451950678772,0.1481858525399824,-0.04138344028054153)));
        }});
    }};

    // hardcoded SQUARE descriptors obtained by experimentation
    //
    public static final List<List<List<Double>>> DESCRIPTORS_SQUARE = new ArrayList<List<List<Double>>>() {{

        // add sets of 8 EFD harmonics
        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-1.9984014443252818E-15,-3.9474596431116675E-16,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(13.654198503705267,4.248207687199458,-12.088726196602524,-6.968435825677171)));
            add(new ArrayList<Double>(Arrays.asList(1.2141163449399932,2.2527712046855997,-8.232207229676394,3.085516629519024)));
            add(new ArrayList<Double>(Arrays.asList(0.10629720974701795,-6.77875721691087,17.581160015035465,-5.78010767677127)));
            add(new ArrayList<Double>(Arrays.asList(-0.47289939859172936,2.1680415512852536,6.404394211369107,-1.8698462644674425)));
            add(new ArrayList<Double>(Arrays.asList(-3.567556036748132,-1.4790528937572915,-1.2998689350476316,1.8455294529840955)));
            add(new ArrayList<Double>(Arrays.asList(-2.0521967451426093,-2.2584817472361283,2.876979667216393,-1.339345015852768)));
            add(new ArrayList<Double>(Arrays.asList(-0.6941700277757682,1.8917263409472194,0.6792097850368185,0.5427404734790715)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-1.3816108750890835E-15,-1.9737298215558337E-16,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(-14.675124708462006,2.896898966144744,1.991783614782557,-4.633313357258827)));
            add(new ArrayList<Double>(Arrays.asList(-3.661015515987529,-2.6973373428617005,2.0777608679733697,1.0100859562486626)));
            add(new ArrayList<Double>(Arrays.asList(11.308668844592102,4.934924191096298,1.1251447182806655,-5.006678243041556)));
            add(new ArrayList<Double>(Arrays.asList(3.431516505040321,-4.531135528272733,-1.0411609040515981,-2.5777199424453063)));
            add(new ArrayList<Double>(Arrays.asList(2.019677733197627,-0.4381332170992502,-0.3691672454524296,0.45535981754877575)));
            add(new ArrayList<Double>(Arrays.asList(-2.278586056075401,-1.0616354174522524,-0.773383596203621,-2.0254437761035953)));
            add(new ArrayList<Double>(Arrays.asList(-1.601998876968863,-1.1989169797716592,-0.09664937680423434,0.9598168062491069)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(9.86864910777917E-16,1.9737298215558337E-16,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(10.213535398212597,-0.2206103422061472,-2.255984519354695,2.7885367589819436)));
            add(new ArrayList<Double>(Arrays.asList(6.409528311190834,-1.5905377187223608,-1.507034848720465,-4.453801202384769)));
            add(new ArrayList<Double>(Arrays.asList(-7.042571812002456,1.646720030060864,2.866896059574927,7.225033623129426)));
            add(new ArrayList<Double>(Arrays.asList(-1.7761139833450432,-0.9103763007208864,-0.39014628888428105,0.48272812075333227)));
            add(new ArrayList<Double>(Arrays.asList(-1.5149174228563107,-0.580438564789394,1.748563823895518,-0.2808962687127617)));
            add(new ArrayList<Double>(Arrays.asList(-2.148002460375784,1.0736655286914805,1.371320167123364,1.7513168962213113)));
            add(new ArrayList<Double>(Arrays.asList(-0.9368815793522071,-0.9481505002195946,0.7483230408629905,-1.242985438503035)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(2.0724163126336253E-15,0.0,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(9.952900002622469,-8.863885121374452,1.5838765844496387,3.6447044935561137)));
            add(new ArrayList<Double>(Arrays.asList(-1.687993108149056,1.9838776044493036,-2.9045257642685245,-2.378382236450703)));
            add(new ArrayList<Double>(Arrays.asList(-15.956129780777397,-3.0821026898211046,-4.550358948822741,2.503425934594267)));
            add(new ArrayList<Double>(Arrays.asList(-0.4905841200839065,1.9514014833229865,2.807999324644968,7.133475217125114)));
            add(new ArrayList<Double>(Arrays.asList(0.9166305037664718,1.6598108443262005,3.2268098821057336,2.1231523791450577)));
            add(new ArrayList<Double>(Arrays.asList(1.0269781364949608,1.0062277620947164,1.3992662766136912,1.1539036804942995)));
            add(new ArrayList<Double>(Arrays.asList(1.6329190895324224,1.3700646903896565,1.6991990752661117,1.1137147643896106)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(3.157967714489334E-15,2.565848768022584E-15,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(22.306398022854534,5.8747548884312755,-0.3865600791075982,-8.18716804146526)));
            add(new ArrayList<Double>(Arrays.asList(12.993717114356686,-7.118728181021108,4.376582020182117,4.618113694865028)));
            add(new ArrayList<Double>(Arrays.asList(-16.253620701067717,9.030890616128035,-11.183327832013655,-2.207475110766007)));
            add(new ArrayList<Double>(Arrays.asList(-8.043189324091387,-4.84594926151363,-6.519050238974571,-2.450953746184094)));
            add(new ArrayList<Double>(Arrays.asList(-6.6443731461091815,0.5459250889976549,0.7329103060418762,-1.6374234148350875)));
            add(new ArrayList<Double>(Arrays.asList(1.0170840390800788,-2.5665995354515383,-4.220053923626036,-2.341432235876316)));
            add(new ArrayList<Double>(Arrays.asList(-0.1571830547520613,-1.6925938732090426,-0.6528781847268831,-0.4536417299230463)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(1.282924384011292E-15,2.565848768022584E-15,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(3.5920238112113605,-4.39913190292536,-7.457960334768605,-4.013737183894579)));
            add(new ArrayList<Double>(Arrays.asList(-2.763993578635319,6.883096086672639,-4.832373899046722,4.0204111213153775)));
            add(new ArrayList<Double>(Arrays.asList(-5.881045043702877,-4.7546438866729925,7.886015426061306,-0.7395757061339941)));
            add(new ArrayList<Double>(Arrays.asList(2.9193066975978526,-0.6232165567176542,-1.8027179773960342,0.008939680719996722)));
            add(new ArrayList<Double>(Arrays.asList(-3.701932385433722,-0.49274229358852156,0.2652602079290945,2.5314556687938197)));
            add(new ArrayList<Double>(Arrays.asList(0.6468472038945011,2.710835035270176,4.0922506813999036,0.794911540865032)));
            add(new ArrayList<Double>(Arrays.asList(2.1125067224632956,-2.013226568829251,1.0792583532413897,-0.6027290044320549)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(2.763221750178167E-15,-7.894919286223335E-16,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(9.957933533264942,-5.87997315421558,5.157287346947809,2.763226393268099)));
            add(new ArrayList<Double>(Arrays.asList(3.966909053604283,2.5891218383710926,6.468436184952136,6.397555897272783)));
            add(new ArrayList<Double>(Arrays.asList(-7.57084066092614,0.7264870477211646,-5.564806858803015,0.5694173302021348)));
            add(new ArrayList<Double>(Arrays.asList(1.7372442047764884,1.7769012134762407,-0.09579648218676813,0.6225505180453536)));
            add(new ArrayList<Double>(Arrays.asList(-1.184115194679413,0.912095732382926,0.168255278084852,0.4314741633132137)));
            add(new ArrayList<Double>(Arrays.asList(-1.8562416602491103,1.3883216054951544,1.4090950397899529,1.4618664364738014)));
            add(new ArrayList<Double>(Arrays.asList(-0.8004949031659303,1.2765858308223528,-0.8138319450340396,-0.20426997936618896)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-1.578983857244667E-15,-8.388351741612294E-16,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(3.194490246795595,5.608005972384526,8.41377479157581,2.7282332556424)));
            add(new ArrayList<Double>(Arrays.asList(-9.071874866360298,-5.019747847689639,10.463990786902658,-7.366143179567293)));
            add(new ArrayList<Double>(Arrays.asList(6.428536925980443,-0.8679445701164538,-1.4657383493969482,3.5004208055641834)));
            add(new ArrayList<Double>(Arrays.asList(1.7110762610452657,1.8118232065860331,0.26486362603093344,-1.2819423273974488)));
            add(new ArrayList<Double>(Arrays.asList(3.1510873798366386,-0.8109672375959777,-4.443728035188068,0.08295126662309475)));
            add(new ArrayList<Double>(Arrays.asList(-0.39565020836373216,0.5070168351592171,2.437205775840795,0.1837118488445027)));
            add(new ArrayList<Double>(Arrays.asList(-1.1321274330903845,-1.4082433473681482,-0.9146237527517012,-0.05218751272066129)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-4.440892098500626E-16,-9.43689570931383E-16,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(-0.471829740147821,1.8096023896248417,1.112394072314108,-3.0719938244934255)));
            add(new ArrayList<Double>(Arrays.asList(3.378206326423737,-4.547783398382532,7.727514447894135,2.3023704220705703)));
            add(new ArrayList<Double>(Arrays.asList(0.4537171439161071,2.9899833550565558,3.046897075273659,-0.9427049467317015)));
            add(new ArrayList<Double>(Arrays.asList(0.15841397342825447,-1.546739347641607,0.9429298094797788,0.14790189638057286)));
            add(new ArrayList<Double>(Arrays.asList(1.6250156950236954,1.0126937700544567,-0.06269587060426374,-1.69620620924018)));
            add(new ArrayList<Double>(Arrays.asList(-0.6821893578392411,-2.097207825890585,-1.6705178002126737,1.3470682082338499)));
            add(new ArrayList<Double>(Arrays.asList(1.7111669879206612,1.5632724747720488,0.4139384171332329,-0.2825825626683691)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-9.86864910777917E-16,1.1842378929335002E-15,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(-7.6971349865561915,-4.548445325416036,-7.088924954281985,1.700627890045141)));
            add(new ArrayList<Double>(Arrays.asList(1.1921779085310993,5.181335322266645,-4.30631510798484,0.9960215986867187)));
            add(new ArrayList<Double>(Arrays.asList(-2.9968684631601326,-0.08288400237227046,11.40001846473487,-2.211346449651205)));
            add(new ArrayList<Double>(Arrays.asList(2.5203712839472527,-0.4823614027930301,0.28243393864721017,0.9506980609072333)));
            add(new ArrayList<Double>(Arrays.asList(1.6799554745184389,0.3222442071992326,-0.5777726225383645,-0.6048126339535107)));
            add(new ArrayList<Double>(Arrays.asList(-0.5793172421405626,-0.13109933598506074,1.625318112610488,-0.08053333285179108)));
            add(new ArrayList<Double>(Arrays.asList(1.8197244238006876,0.08678249806195498,-0.1179937021983546,0.3756246324575209)));
        }});
    }};

    // hardcoded VEE-shape descriptors obtained by experimentation
    //
    public static final List<List<List<Double>>> DESCRIPTORS_VEE = new ArrayList<List<List<Double>>>() {{

        // add sets of 8 EFD harmonics
        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-3.739698609263685E-16,1.495879443705474E-15,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(7.582681919110617,-1.0378568078713484,6.7657265102573225,-1.4547211633521095)));
            add(new ArrayList<Double>(Arrays.asList(1.9102637973471177,2.556713749514134,-0.25090418182864577,-3.0764787502695663)));
            add(new ArrayList<Double>(Arrays.asList(0.47583490051459904,0.003022674384557564,-2.550367405593946,-0.9950599930502317)));
            add(new ArrayList<Double>(Arrays.asList(-0.21086318667081388,-0.35924059254050944,-1.7880791361183386,-1.7863909438075392)));
            add(new ArrayList<Double>(Arrays.asList(0.2634392572134269,-0.23090886490239138,-0.8326336654497922,-0.6559540193655378)));
            add(new ArrayList<Double>(Arrays.asList(0.16232478477749399,-0.6078283470048865,-1.4516060310856531,-1.0605350024420326)));
            add(new ArrayList<Double>(Arrays.asList(-1.0644042555224085,-1.3486493610349015,-0.3264775044924792,-0.6372641584346339)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(7.47939721852737E-16,3.739698609263685E-16,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(8.671552736051403,1.084589739638377,3.5782285851001667,-1.2488380177954703)));
            add(new ArrayList<Double>(Arrays.asList(0.8032934428994015,-1.9363673173460105,-0.4449276086907581,0.684371885195086)));
            add(new ArrayList<Double>(Arrays.asList(0.7790381921668497,1.3120255387873674,-2.3963572885947158,0.8533571125075005)));
            add(new ArrayList<Double>(Arrays.asList(-0.681979640983828,0.14891895145211265,0.1550074386048073,0.2883789244129517)));
            add(new ArrayList<Double>(Arrays.asList(-0.8528770248900631,0.30019459329792564,-1.7224687616781384,0.4086415086026002)));
            add(new ArrayList<Double>(Arrays.asList(-0.563275922286633,0.27272424661029354,-0.8573364721726708,0.46165065079841894)));
            add(new ArrayList<Double>(Arrays.asList(-0.6570160097762351,0.066751426680766,-0.3624182732465575,0.46638816902760016)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-1.390192309095848E-15,1.6218910272784895E-15,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(3.328996767760112,1.048639513278073,7.91565302164108,-1.0508650865094165)));
            add(new ArrayList<Double>(Arrays.asList(-2.1967373329408284,-2.0191838139668516,-0.18832239649965765,-0.4064749806213836)));
            add(new ArrayList<Double>(Arrays.asList(0.7278214908102135,-0.1405373486555113,0.4447865766396843,-0.4421653311555282)));
            add(new ArrayList<Double>(Arrays.asList(0.0835789034100685,-0.3809916707915099,0.2427333004479649,-0.91875595096696)));
            add(new ArrayList<Double>(Arrays.asList(-0.5867973287183177,-0.5459215699952952,0.754929404040904,0.4436978402323292)));
            add(new ArrayList<Double>(Arrays.asList(0.7175229041283527,-2.6343129697817025E-4,-0.9237698241084268,-0.6214904418449316)));
            add(new ArrayList<Double>(Arrays.asList(0.16632424043677696,0.1865934587180287,0.9633814865890141,0.04133844159440668)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-1.3692750637043596E-15,-2.516505522483688E-15,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(5.655541530777177,-0.6928732276580175,6.560515201067668,1.053073411433488)));
            add(new ArrayList<Double>(Arrays.asList(-3.9289690443072436,0.6529029709368316,-0.19670044365305314,1.616302689354887)));
            add(new ArrayList<Double>(Arrays.asList(0.3595416587805226,-0.41663795008400806,-1.332928196514709,-0.41605691727817345)));
            add(new ArrayList<Double>(Arrays.asList(0.6804927479870443,-0.22498384036300598,0.9225081530401537,-0.4474164152298617)));
            add(new ArrayList<Double>(Arrays.asList(-0.15502666643570026,-0.6088532860795922,0.038082175625420475,-0.14642838890071105)));
            add(new ArrayList<Double>(Arrays.asList(0.11322336930117603,0.12758511164712383,-0.3332000961533249,-0.13268797573120686)));
            add(new ArrayList<Double>(Arrays.asList(-0.1815990220145474,0.2444287047197567,0.02787262363427281,0.6140967384756982)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-3.2722362831057244E-16,-2.430804096021395E-15,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(2.375100622768312,0.6014372997903977,10.280300118627075,-1.1991186805344782)));
            add(new ArrayList<Double>(Arrays.asList(-1.9088482936874613,0.22120243963537137,-4.4538724082935435,-2.8474385120357124)));
            add(new ArrayList<Double>(Arrays.asList(1.8057855834886962,-1.6972839845006162,-0.8143316427687667,-0.38373337236662264)));
            add(new ArrayList<Double>(Arrays.asList(0.2637051545775798,0.278149977273919,-0.22612500245890835,-0.052279694841532554)));
            add(new ArrayList<Double>(Arrays.asList(-0.3601336495786069,-0.7545433676348829,0.33093378922256006,0.28788943945371254)));
            add(new ArrayList<Double>(Arrays.asList(0.32901207723022097,0.09241481612612865,0.3281681203448522,-0.8035770855831967)));
            add(new ArrayList<Double>(Arrays.asList(-1.1890860063666497,-0.9877985249761672,-0.30967364002755393,0.2566316088435554)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(2.9605947323337506E-16,5.427757009278543E-16,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(2.7271103623555253,-2.977382350293476,9.210713272598092,0.6921134537782824)));
            add(new ArrayList<Double>(Arrays.asList(-2.90149944381541,-0.4943456961911024,-2.1477440022773195,-0.38339737109927086)));
            add(new ArrayList<Double>(Arrays.asList(-0.04305717714391039,-0.7270597889815561,-0.4503316981759307,0.27117429407845794)));
            add(new ArrayList<Double>(Arrays.asList(0.9036611645264574,0.35098351127656635,0.17399234924096818,-0.2795305947083028)));
            add(new ArrayList<Double>(Arrays.asList(-0.22286160783417525,-0.4552235080640579,-0.5098831681127843,0.7807558047377299)));
            add(new ArrayList<Double>(Arrays.asList(-0.1808963954018651,0.07912183894430715,0.5286549911367022,-0.39614447722522284)));
            add(new ArrayList<Double>(Arrays.asList(-0.5294076503125762,-0.15495910326594367,-0.5013351651206306,0.3760445920916511)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-2.4671622769447922E-15,-1.7270135938613544E-16,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(-8.66960919346963,1.5697597398743115,-7.95386677484654,-2.503425004255949)));
            add(new ArrayList<Double>(Arrays.asList(-0.5507934711550078,-0.5439554956053876,-3.5816013196671945,2.072661920453485)));
            add(new ArrayList<Double>(Arrays.asList(-1.175582427067557,-0.03682834188531535,-1.571767515333663,0.31984075219890035)));
            add(new ArrayList<Double>(Arrays.asList(-0.42118084671683365,-0.8138636077314959,-1.4583060053215633,-0.6167494720802438)));
            add(new ArrayList<Double>(Arrays.asList(-0.9877647089180652,0.3625662006773363,-0.7101455528902249,-0.06359413408076678)));
            add(new ArrayList<Double>(Arrays.asList(-1.2870243795308713,0.15645548121946096,-0.5039207715031175,-0.4318914137486958)));
            add(new ArrayList<Double>(Arrays.asList(-1.4056931656867284,-0.09002607528856212,-0.4130270500551661,0.4170793102212458)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-2.5710427938687833E-15,-1.2621482806264937E-15,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(2.350299104188122,0.22999795417725155,7.659312128353051,0.08060605022199081)));
            add(new ArrayList<Double>(Arrays.asList(-0.5355494882504823,-2.256958892809656,-1.7074494424640694,0.4520852958913336)));
            add(new ArrayList<Double>(Arrays.asList(0.6250575094112618,0.954074796788694,-1.5437404187651018,1.0906958427496367)));
            add(new ArrayList<Double>(Arrays.asList(0.0675438079740973,-0.2342835038811153,-0.6453166030509578,0.22192834638127457)));
            add(new ArrayList<Double>(Arrays.asList(-0.09237325329494904,0.8548180091165481,-0.12958798824019005,0.20340091415959874)));
            add(new ArrayList<Double>(Arrays.asList(-1.00348147972431,0.2789831937703399,0.5400840309388406,0.038044051836599764)));
            add(new ArrayList<Double>(Arrays.asList(-0.4854924044034324,0.43099821533071925,-0.29134190357456724,-0.34592601788055344)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(2.565848768022584E-15,9.86864910777917E-16,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(-8.57960221952046,-1.6097192747259623,-9.449151532043915,2.634094955770779)));
            add(new ArrayList<Double>(Arrays.asList(-1.91372958106445,-1.5199816652118232,-3.6273302917511665,-1.4642322956070524)));
            add(new ArrayList<Double>(Arrays.asList(-0.022405478102760796,-0.6778791783928434,-1.8391213007192588,-1.1052586256350905)));
            add(new ArrayList<Double>(Arrays.asList(-0.5655496978425401,0.2456410152312805,-1.0721099314384182,-0.3541415311655319)));
            add(new ArrayList<Double>(Arrays.asList(-0.1131365674188034,0.05887000859273455,-1.3335929711788703,-0.253752419606053)));
            add(new ArrayList<Double>(Arrays.asList(0.0160760004878266,-0.20670902728022034,-0.5432895309274574,-0.07751391208750882)));
            add(new ArrayList<Double>(Arrays.asList(-0.8044358438328056,0.024908090564427898,0.0061998963530047,0.08591575889714922)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-2.565848768022584E-15,-1.973729821555834E-15,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(0.7349582180318756,-1.0167747737919484,-8.926739180307495,-0.30152901846658753)));
            add(new ArrayList<Double>(Arrays.asList(0.22363408530959988,-1.7067940770719288,0.032089241361253636,0.2897998998258609)));
            add(new ArrayList<Double>(Arrays.asList(-0.6864453132099987,0.9869370785979894,-0.4705998718903782,0.25359462392598725)));
            add(new ArrayList<Double>(Arrays.asList(-0.9619562685800898,0.13600011402839648,-0.3341690982364445,0.029354183945309503)));
            add(new ArrayList<Double>(Arrays.asList(-0.6806422723863083,0.4918675336854907,-0.22957729333443452,0.2217386705876267)));
            add(new ArrayList<Double>(Arrays.asList(-0.09437880458186962,0.41864981465050644,-0.8299932772611758,0.1891573533867197)));
            add(new ArrayList<Double>(Arrays.asList(-0.0149317301702721,-0.3208380852385859,0.3066514787148028,0.3717889445660435)));
        }});
    }};


    // hardcoded TRIANGLE descriptors obtained by experimentation
    //
    public static final List<List<List<Double>>> DESCRIPTORS_TRIANGLE = new ArrayList<List<List<Double>>>() {{

        // add sets of 8 EFD harmonics
        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(1.1842378929335002E-15,-5.921189464667501E-16,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(-9.48848300376498,-3.192615059157617,-11.996408382628768,2.3306119288646)));
            add(new ArrayList<Double>(Arrays.asList(0.28625449792729873,0.6110198946920915,5.462569163101164,-1.7327990185075426)));
            add(new ArrayList<Double>(Arrays.asList(1.1100437031185544,0.8779683565501855,6.361579471923405,0.9241402685851093)));
            add(new ArrayList<Double>(Arrays.asList(0.26447587362727887,-0.2164841179725956,1.4754137146554875,-0.7472066492784796)));
            add(new ArrayList<Double>(Arrays.asList(2.0719083774075218,0.05942660572853644,1.1244781522870972,0.8301968378390371)));
            add(new ArrayList<Double>(Arrays.asList(1.0090804160655218,-0.5021272596754343,0.6941049113895433,-1.0139542528824474)));
            add(new ArrayList<Double>(Arrays.asList(0.9505164710990126,0.35285773255966296,-1.0304595986866123,0.02656602351295212)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(2.3684757858670005E-15,1.1842378929335002E-15,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(-18.181365867836607,-1.0641623082579708,-4.189003803367369,0.7482695064512797)));
            add(new ArrayList<Double>(Arrays.asList(0.09149405503302709,1.5725227147488787,3.3024894458047904,-3.5247056647920045)));
            add(new ArrayList<Double>(Arrays.asList(3.6190947620426472,1.201611461524255,3.102174948532585,-1.1127378787340916)));
            add(new ArrayList<Double>(Arrays.asList(1.977424156448865,-1.6217511147690973,0.48779189255115124,-1.5461434740257445)));
            add(new ArrayList<Double>(Arrays.asList(1.0690216191998503,-1.1415473346515024,-0.5543521944362596,-1.2994654458133048)));
            add(new ArrayList<Double>(Arrays.asList(1.656853482139025,-0.2094242699282611,0.41573443850380676,0.6352996955791471)));
            add(new ArrayList<Double>(Arrays.asList(1.4768640833608426,-1.0329003480685959,0.6099255583877404,0.443909982691085)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(1.578983857244667E-15,-9.86864910777917E-16,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(-22.90175013371934,-1.322541611217954,-3.3464025995499544,-3.232127150177209)));
            add(new ArrayList<Double>(Arrays.asList(1.185281614072013,0.7610726365922076,6.755605515561526,-4.646924232491566)));
            add(new ArrayList<Double>(Arrays.asList(5.856655667599399,-0.36147166549814475,3.8635784917253613,-1.4229846474543681)));
            add(new ArrayList<Double>(Arrays.asList(2.107182850460104,-0.8269151290575474,-0.37330157230211386,-1.0086428291096154)));
            add(new ArrayList<Double>(Arrays.asList(0.9857074060813529,-1.4186486856432985,-0.7823254547937996,-0.42764208090750144)));
            add(new ArrayList<Double>(Arrays.asList(-0.8054047379372219,-0.6124997787724872,0.18264543704922903,0.016629982682451267)));
            add(new ArrayList<Double>(Arrays.asList(0.3211959182615569,-0.6601828500632168,-0.0612237210120189,-0.4301323242088535)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-7.894919286223335E-16,-1.1842378929335002E-15,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(11.413219743577647,-0.029672608329782097,6.347324614940638,4.981091243189872)));
            add(new ArrayList<Double>(Arrays.asList(-3.6792023652134693,-2.535788600796692,-6.847397598328548,3.5327462129933855)));
            add(new ArrayList<Double>(Arrays.asList(-2.1763642474925944,2.696478459864678,-0.98024242252746,1.3337315541033183)));
            add(new ArrayList<Double>(Arrays.asList(-1.2624597004295244,-0.05453951528634822,-2.3435386720143687,1.9277422949057126)));
            add(new ArrayList<Double>(Arrays.asList(-1.017973319069483,1.0292359639460185,-0.6783099046745652,0.9363596553923972)));
            add(new ArrayList<Double>(Arrays.asList(-1.6153700255666719,1.1726996620682442,-0.514669804336146,0.11153427469140295)));
            add(new ArrayList<Double>(Arrays.asList(-0.9127932491008334,1.0400075768929689,-0.03755204312840534,-0.3415211695529814)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(3.9474596431116675E-16,-5.427757009278543E-16,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(-15.356509475351489,5.261125634109768,-13.782858532720047,-0.22359029298215805)));
            add(new ArrayList<Double>(Arrays.asList(-0.7076690525729263,-5.445721434209544,5.934742734278014,6.27151808509938)));
            add(new ArrayList<Double>(Arrays.asList(4.285100928622494,1.2438209015501442,8.89848790289834,3.4056454881411087)));
            add(new ArrayList<Double>(Arrays.asList(2.800942579247276,0.44099549309928743,1.8407480567143857,-0.7105462547944505)));
            add(new ArrayList<Double>(Arrays.asList(1.4136592690974699,1.03972967135091,1.4635508686006824,-1.2522721941541095)));
            add(new ArrayList<Double>(Arrays.asList(0.6826748432995353,1.000811343484737,1.3912369904751751,0.8151761157107026)));
            add(new ArrayList<Double>(Arrays.asList(1.8174455643287375,0.6726463501098588,0.5974130894556529,-0.7357975420494475)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(1.2538989454590002E-15,2.5077978909180004E-15,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(14.626520168598669,-0.5345124227665382,13.797870935943147,-0.3477865696571513)));
            add(new ArrayList<Double>(Arrays.asList(-5.673278976606358,9.10282956328367,-15.68872024555892,-2.134584818795705)));
            add(new ArrayList<Double>(Arrays.asList(-0.22763370088027327,1.6346258571841998,-7.649317910183318,-2.8168091214701714)));
            add(new ArrayList<Double>(Arrays.asList(-3.5483389576199547,0.5373161965421743,-0.38211408510165845,-5.812373382920101)));
            add(new ArrayList<Double>(Arrays.asList(-2.1954359429523715,-2.7032742573907913,0.21276843766510384,-3.05998750988718)));
            add(new ArrayList<Double>(Arrays.asList(0.04830642504723294,-4.007641135022997,0.22469302374106886,-1.6137204907940512)));
            add(new ArrayList<Double>(Arrays.asList(-1.3455471942894075,-2.5855241087017853,0.47489170840997186,-1.771019819005126)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(1.9737298215558337E-16,1.3816108750890835E-15,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(9.570839573518965,-0.264334271719055,4.614264813337317,-6.343391473350302)));
            add(new ArrayList<Double>(Arrays.asList(-4.345015610090146,2.902551676805078,-10.342940258948595,-2.923098824531799)));
            add(new ArrayList<Double>(Arrays.asList(-0.5557129824979349,-2.4254133232535886,-2.3857556349068902,-1.1877529479903954)));
            add(new ArrayList<Double>(Arrays.asList(-1.2688449420407137,-1.0204484937110205,-2.3104203234299456,-1.5933578971816984)));
            add(new ArrayList<Double>(Arrays.asList(-2.850275585444006,-1.3581772479387242,1.3425798569643461,-0.650009671976819)));
            add(new ArrayList<Double>(Arrays.asList(-0.21032733210875576,-0.5104494873335018,-0.8659701335734171,-0.39165326783222887)));
            add(new ArrayList<Double>(Arrays.asList(-1.3410867204775496,-1.2295922225361002,0.1068914534692167,-0.15312194583863706)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(0.0,-2.9605947323337506E-16,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(-4.024728052624433,4.321233640817132,0.17550706316738543,12.506330267321552)));
            add(new ArrayList<Double>(Arrays.asList(-10.867595889904226,-4.509150244601576,5.123399906692897,-2.8030809176132734)));
            add(new ArrayList<Double>(Arrays.asList(1.1070724694596201,3.346923348358022,10.011521705512514,-2.288382822091646)));
            add(new ArrayList<Double>(Arrays.asList(3.683414573956022,1.239876651057062,2.8960729172843003,1.4192595370003238)));
            add(new ArrayList<Double>(Arrays.asList(2.0003464136529887,-2.2690290412517267,3.5850229343480406,-0.7088608391035336)));
            add(new ArrayList<Double>(Arrays.asList(3.279665071255913,0.2508825028023916,0.5323237417579807,-2.520983738714949)));
            add(new ArrayList<Double>(Arrays.asList(1.427972795778707,-0.2573134389685953,-0.12447352619272559,0.6973412671116911)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-7.894919286223335E-16,-1.1842378929335002E-15,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(17.44884294843017,-0.06999206401964465,5.148126106297252,3.0133490498131366)));
            add(new ArrayList<Double>(Arrays.asList(-5.14243723732562,-2.055457743150486,-2.742975499982405,5.373050586692859)));
            add(new ArrayList<Double>(Arrays.asList(-5.5511027015050765,-0.969823139692175,-1.8617473297086695,2.7422465998600978)));
            add(new ArrayList<Double>(Arrays.asList(-2.3485728333346474,0.015163529666795473,-1.0687203638310367,2.471365633531082)));
            add(new ArrayList<Double>(Arrays.asList(-1.450096619987897,1.2164056502494074,0.9088524092515978,1.4343090185082559)));
            add(new ArrayList<Double>(Arrays.asList(-0.22601093828879154,1.4611292929466397,-1.1239703082122974,1.5275830338454963)));
            add(new ArrayList<Double>(Arrays.asList(-1.7757054384483224,1.2323882614735953,-1.3480948194243239,0.8139713378140174)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(1.578983857244667E-15,1.7763568394002505E-15,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(-21.213045566880805,-0.3529693529695939,-4.735261600134324,5.247832904875922)));
            add(new ArrayList<Double>(Arrays.asList(5.248565907357139,-3.227881772114005,5.982014543279498,2.8618673575581317)));
            add(new ArrayList<Double>(Arrays.asList(5.825140201574497,1.8716752993437598,-0.43562565911968276,0.4738997627573107)));
            add(new ArrayList<Double>(Arrays.asList(1.884158074322345,1.1334726449208914,0.497853282070655,1.2939617446859955)));
            add(new ArrayList<Double>(Arrays.asList(1.4471393500220127,1.9922494445941632,2.1576083548392697,0.237142878565693)));
            add(new ArrayList<Double>(Arrays.asList(-1.5274674120200111,0.41198036311804986,0.2990454061664754,-0.6803309961970483)));
            add(new ArrayList<Double>(Arrays.asList(-1.054640764110332,-0.1162483000806634,1.3525428230987546,0.2028364380859199)));
        }});

    }};

    // hardcoded LINEAR locus descriptors obtained by experimentation
    //
    public static final List<List<List<Double>>> DESCRIPTORS_LINE = new ArrayList<List<List<Double>>>() {{

        // add sets of 8 EFD harmonics
        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-1.973729821555834E-15,3.0346096006420944E-15,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(1.2081724967765057,-0.5273094005944474,8.81828494583515,0.10677963995467382)));
            add(new ArrayList<Double>(Arrays.asList(0.48548790738761144,0.09192648925987551,0.4964967247952546,-0.931171702079808)));
            add(new ArrayList<Double>(Arrays.asList(0.0234958648851583,0.07365240453596818,0.2042984449114814,-0.4280122982360199)));
            add(new ArrayList<Double>(Arrays.asList(0.9599115358825546,0.2670546098788555,0.6818321451082491,-0.1473890755853369)));
            add(new ArrayList<Double>(Arrays.asList(-0.37036832668540237,-0.10189496506391642,0.36835042113333344,-0.06039207739237789)));
            add(new ArrayList<Double>(Arrays.asList(0.8829808334459532,-0.1687253891022705,0.136821019910704,-0.27282942939667765)));
            add(new ArrayList<Double>(Arrays.asList(0.16636997766704764,-0.17465549349443651,0.8957147790106381,0.11599556380683568)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(4.243519116345043E-15,1.282924384011292E-15,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(10.179167842216568,-0.6491372234896923,14.482530573124285,0.264739275323847)));
            add(new ArrayList<Double>(Arrays.asList(-1.0594984244990562,-0.33341278861290363,-3.6997895403558663,-1.902011013055612)));
            add(new ArrayList<Double>(Arrays.asList(1.9148769208578353,-1.6916641189528505,1.3226702511057928,-0.5884035838561129)));
            add(new ArrayList<Double>(Arrays.asList(-1.8856413800337624,-0.17366190384972907,-1.552861351951796,-0.31436039053967935)));
            add(new ArrayList<Double>(Arrays.asList(-1.028423201683,0.8613745249095762,-0.4043781105205918,-0.9824381872208955)));
            add(new ArrayList<Double>(Arrays.asList(-1.1795193878355046,-1.2663522710737747,1.5545758807747343,-0.9535183189130928)));
            add(new ArrayList<Double>(Arrays.asList(0.040758328418695984,-0.5632122639178607,-0.3540060808706016,0.0447220877903497)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(5.609547913895527E-16,1.402386978473882E-15,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(2.5768337272238995,2.0841073195654927,10.38684972352043,-0.6907424334248221)));
            add(new ArrayList<Double>(Arrays.asList(2.3411973253214065,0.5042681170038115,-2.0328224308525153,0.6262897380758605)));
            add(new ArrayList<Double>(Arrays.asList(-0.6695532648216984,-1.7428697299177813,0.24613808311042856,0.2965249424716091)));
            add(new ArrayList<Double>(Arrays.asList(0.9222909871570202,0.38440130708487164,-1.4385887865804594,0.4193002938954735)));
            add(new ArrayList<Double>(Arrays.asList(0.8030179535493693,0.4731299595074419,0.10259938956084864,0.5696021941554255)));
            add(new ArrayList<Double>(Arrays.asList(-0.5273748077930883,-0.1647561547891242,-1.666038266562886,0.19262473296486107)));
            add(new ArrayList<Double>(Arrays.asList(-0.002970696589224091,0.37338919654543723,1.3385736598286055,0.6961279206305003)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-1.624431583398913E-15,1.2621482806264937E-15,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(-3.648771551425397,-0.9753904746589076,-7.2440684617111915,0.14375248105686114)));
            add(new ArrayList<Double>(Arrays.asList(0.692863166958225,0.34974149924527653,-0.923116680786267,0.2879242111409222)));
            add(new ArrayList<Double>(Arrays.asList(-0.5403295609473777,-0.3331749309734047,-1.0192455199942174,1.3552175355998082)));
            add(new ArrayList<Double>(Arrays.asList(0.19550043620294325,-0.09132123863246305,-0.02653885864323591,-0.2513548190120955)));
            add(new ArrayList<Double>(Arrays.asList(-0.18255854590866677,-0.7575410680719179,-0.5093546776416839,0.5472582624680894)));
            add(new ArrayList<Double>(Arrays.asList(0.664616275785745,-0.4437760915794162,-0.31879471675341187,1.0984787675831336)));
            add(new ArrayList<Double>(Arrays.asList(-0.11259123819652328,0.1210250534587048,0.19100686343735276,-1.033947937993527)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-9.005142310848492E-16,2.9605947323337506E-16,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(-12.628347906812134,0.8738046055512543,-8.640095508380972,-0.9455103195722265)));
            add(new ArrayList<Double>(Arrays.asList(-4.13706828796161,1.4193580187274044,-6.335368806421623,-0.6476368907203655)));
            add(new ArrayList<Double>(Arrays.asList(-1.2806824092713576,0.6211222020523977,-3.1183121509020495,-0.9572668177369594)));
            add(new ArrayList<Double>(Arrays.asList(-1.1553144859187987,-0.8874838652944766,-1.0564364622759448,-0.9369683206359419)));
            add(new ArrayList<Double>(Arrays.asList(-0.508787970639252,0.06397732605468466,-1.0231628517197258,0.7894393487243264)));
            add(new ArrayList<Double>(Arrays.asList(-0.302630521748188,-0.33103104624504504,-0.026840741354425098,0.32972792459964634)));
            add(new ArrayList<Double>(Arrays.asList(-1.4758883443258963,-0.52796183321027,0.033136112322456855,-0.31804583963089206)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-9.005142310848492E-16,2.9605947323337506E-16,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(-12.628347906812134,0.8738046055512543,-8.640095508380972,-0.9455103195722265)));
            add(new ArrayList<Double>(Arrays.asList(-4.13706828796161,1.4193580187274044,-6.335368806421623,-0.6476368907203655)));
            add(new ArrayList<Double>(Arrays.asList(-1.2806824092713576,0.6211222020523977,-3.1183121509020495,-0.9572668177369594)));
            add(new ArrayList<Double>(Arrays.asList(-1.1553144859187987,-0.8874838652944766,-1.0564364622759448,-0.9369683206359419)));
            add(new ArrayList<Double>(Arrays.asList(-0.508787970639252,0.06397732605468466,-1.0231628517197258,0.7894393487243264)));
            add(new ArrayList<Double>(Arrays.asList(-0.302630521748188,-0.33103104624504504,-0.026840741354425098,0.32972792459964634)));
            add(new ArrayList<Double>(Arrays.asList(-1.4758883443258963,-0.52796183321027,0.033136112322456855,-0.31804583963089206)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(2.6398636363309275E-15,9.868649107779169E-17,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(-6.0161850960219905,1.2789408245083775,-11.48596450052513,-0.28444403087755976)));
            add(new ArrayList<Double>(Arrays.asList(-0.7164986646294502,0.6748810030587786,-2.393078839246779,-1.3026355575962834)));
            add(new ArrayList<Double>(Arrays.asList(-1.2810368452098015,-0.4195420816869558,-0.21639566831113347,-0.6871149455240015)));
            add(new ArrayList<Double>(Arrays.asList(-0.7359813033736304,-0.60073657148865,-0.23188858565846604,-0.6552611835268292)));
            add(new ArrayList<Double>(Arrays.asList(-0.4882975631639783,-0.1468875984064427,-0.2954221171500273,-0.14776212412498493)));
            add(new ArrayList<Double>(Arrays.asList(-0.29984926232410125,-0.7221130150276754,0.04011421922542709,-0.8386047220169127)));
            add(new ArrayList<Double>(Arrays.asList(-0.8965743297349384,-0.0478279047955895,0.2591107100074336,-0.38294138442599357)));
        }});

        add(new ArrayList<List<Double>>() {{
            add(new ArrayList<Double>(Arrays.asList(-4.934324553889585E-16,-6.41462192005646E-16,0.0,0.0)));
            add(new ArrayList<Double>(Arrays.asList(0.959534428898615,-0.6402600040780042,-10.468814768736326,0.8100289149434792)));
            add(new ArrayList<Double>(Arrays.asList(-3.3232031091412395,-3.210690252384182,-2.311954263056666,1.59209355532622)));
            add(new ArrayList<Double>(Arrays.asList(0.5104583080782535,0.6326490364023968,0.9724289466513889,0.23219159460092578)));
            add(new ArrayList<Double>(Arrays.asList(0.22891710350261707,0.44866053931149397,-1.7236594645126653,-0.5785613496595535)));
            add(new ArrayList<Double>(Arrays.asList(-1.062533257437284,0.12534250779722075,-0.46712580350447336,-0.1505007083202477)));
            add(new ArrayList<Double>(Arrays.asList(-0.2454285414767443,-0.02502474319024123,-0.2737957430433881,-0.28919302449538653)));
            add(new ArrayList<Double>(Arrays.asList(-0.7804153628797978,-0.5037017147763869,-0.26720533380452255,0.42990726497403364)));
        }});
    }};
}
