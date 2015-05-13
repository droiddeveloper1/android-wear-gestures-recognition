# android-wear-gestures-recognition
Android Wear Gesture Recognizer.
This combined Android Wear/Android Mobile application attempts to recognize some basic gestures/motions from a wearable.  
Several gestures are predefined(circle, line, vee, triangle, square) and their motion coefficients precomputed.

Summary:
Gesture recognition by analysis of wearable's motion pattern

Introduction:
This combined Android Wear/Android Mobile application attempts to recognize some basic gestures/motions from a wearable by analyzing the associated Elliptic Fourier Descriptors(EFD).

Several gestures are predefined(circle, line, vee, triangle, square) and their motion coefficients pre-computed. These pre-computed gestures are applied in the classification stage of the analysis. 
The app behaves in two modes: (1)it analyzes the wearable's motion/gesture, (2) it writes a file to externalstorage that contains the results of each motion analysis (i.e. a set of 8 EFD harmonics). 

Details:
The Android Wear component collects triple-axis accelerometer information and sends it (via Bluetooth MessageApi?) to the paired Android phone/mobile device. The Android mobile app then applies PCA(Principal Components Analysis) to reduce the dimensionality of the received 3D data to 2D for further analysis. I used a PCA algorithm based on SVD(Singular Value Decomposition), as opposed to the EVD(Eigenvalue Decomposition) alternative, because although EVD may be computationally faster, it is not guaranteed to be numerically stable. Elliptic Fourier Descriptors(EFD) of the 2D data are then computed (just the first 8 harmonics,) and compared to the set of pre-computed descriptors. EFD was chosen over other competing techniques (Hidden Markov Models, Dynamic Time Warping, Recurrent Neural Networks, etc.) due to the availability of an efficient mobile library, its speed of computation, and its rotation-, scale- and translation-invariance properties. 
For those interested, the following sites contain more information about EFDs: 
http://demonstrations.wolfram.com/FourierDescriptors/ 
https://www.youtube.com/watch?v=jMI8a9Jg8N0 
http://knight.temple.edu/~lakamper/courses/cis9601_2009/etc/fourierShape.pdf 
http://research.cs.tamu.edu/prism/lectures/pr/pr_l29.pdf 
The PCA, SVD and matrix computations are done using Efficient Java Matrix Library(EJML / http://code.google.com/p/efficient-java-matrix-library/).

The 3D scatterplots are rendered using a proprietary closed source OpenGL-based graphics package called OrsonCharts? (http://www.object-refinery.com/orsoncharts/), so libraries for that are not included in the source code. You will have to purchase a copy of the 3D graphics platform for yourself in order to display the 3D scatter plots of the accelerometer data and unlock the visualization capabilities of the project.

In summary, the gesture recognition algorithm comprises of several components: 
1. collect 3D acceleration data from the wearable 
2. re-dimension the 3D data to planar 2D via PCA (Principal Components Analysis) by projecting the 3D vectors onto a 2D plane-of-best-fit 
3. calculate the Fourier co-efficients(i.e. Elliptic Fourier Descriptors) of the 2D motion vectors 
4. compute a "distance" metric between the measured vectors and a set of pre-computed vectors 
5. sort the list of distance measures in ascending order, and pick the top one as the best match. 

The EFD class was obtained from Katja Schulze's PlantoVision? project (https://github.com/KatjaSchulze/PlanktoVision/tree/master/src/calc).

The app was tested using the following combination of hardware: 
- Motorola Droid Turbo ('KitKat?' 4.4.4) 
- Motorola "Moto 360" smart watch 
Usage
Android Wear bluetooth debugging instructions can be found here: https://developer.android.com/training/wearables/apps/bt-debugging.html

After pairing the Android wearable with the mobile device, install both components of the app. On the wearable UI, click the "Send2Phone?" button to start capturing accelerometer data. Default capture window is 1500ms. The wearable UI will turn from black to red while motion data is being captured, then back to black again after data capture has completed.

To obtain optimum classification results, start moving the wearable through the gesture as you tap on "Send2Phone?". Do not tap on the button then wait to start the gesture as accelerometer zero-point "noise" will be captured as part of the valid data set; this will pollute the generated data and lead to misclassifications.

On the mobile device, click the "3D-2D toggle" button to switch the scatter plot display between the full raw 3D vectors and the "flattened" 2D vectors in 3D accelerometer space. 
Use your finger(s) to manipulate, scale, and rotate the scatter plot in order to view the data from different perspectives.

Click on the "Elliptic Fourier Descriptor" button to compute the EFD harmonics (just the lowest 8 harmonics) and to obtain a classification decision. The classification decision will appear as a Toast on the screen. By default, the EFD data will also be written out to a file in external storage on the mobile device (default location: /GESTURES/ folder under external storage root folder). 
This is a text file containing sets of EFD harmonics(4-tuples) that can be directly appended to the existing training set in the app.

Improvements:
In order to obtain more accurate classification results, you can run the app to generate more sets of descriptors for a particular motion gesture and simply append the corresponding nested lists of descriptors (4-tuple doubles values) to the corresponding data structure defined in com.dmt.gestureproject_1.Constants.java . 

I chose to compute only the first 8 EFD harmonics for each gesture. Perhaps increasing or decreasing the number of computed harmonics may lead to an improvement in the classification accuracy.
