# Goal

The Goal of this Project is to Design a given UI Specification using Jetpack Compose

## General Grading Criteria

- [ ] All code has to be written in Kotlin
    - If you are using external dependencies it is fine if these are written in Java
- [ ] Only Jetpack Compose 
    - [ ] Single Activity using [ComponentActivity](https://developer.android.com/reference/androidx/activity/ComponentActivity)
    - [ ] Navigation is using [compose-navigation](https://developer.android.com/jetpack/compose/navigation)
- [ ] Hardcoded Strings are localized
- [ ] Icons are vectors using [material-icons](https://developer.android.com/reference/kotlin/androidx/compose/material/icons/package-summary)
- [ ] UI Follows the [Style Guide](Styleguide.pdf)

## Data

The Data Structure for this Project is given. All Domain Models can be found in the [data](src/main/java/fhs/mmt/nma/pixie/data/) package.

There are ready to use Fake Data and Sample Data Providers available in the [samples](src/main/java/fhs/mmt/nma/pixie/samples/) package

## Tasks

All Tasks are worth a total of **30** Points

### Task 1: Post Card - *2P*

Create a Post Card Component. The [PostCard](src/main/java/fhs/mmt/nma/pixie/ui/home/PostCard.kt) composable including a Preview is already existing. 

- It is not necessary to Display an Image within this Task
- It is not necessary to Apply Text Styles yet
- For now consider Posts to only have a Single Photo


Checklist
- [ ] Spacings and Sizes are following the [Style Guide](Styleguide.pdf)
- [ ] Avatar is round
- [ ] Location is optional
    - [ ] If Location is missing the User Name is Center aligned
- [ ] Like and Comment are [TextButton](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#TextButton(kotlin.Function0,androidx.compose.ui.Modifier,kotlin.Boolean,androidx.compose.foundation.interaction.MutableInteractionSource,androidx.compose.material.ButtonElevation,androidx.compose.ui.graphics.Shape,androidx.compose.foundation.BorderStroke,androidx.compose.material.ButtonColors,androidx.compose.foundation.layout.PaddingValues,kotlin.Function1))
    - [ ] Icons are implemented using [material-icons](https://developer.android.com/reference/kotlin/androidx/compose/material/icons/package-summary)
    - _Note:_ there is no need to do anything when clicking the buttons

### Task 2: Comments - *2P*

Add existing Comments to the Card. Please be aware that Comments are optional and could be empty.
The PostCard should only display the **latest** 2 Comments. If the total amount is more than 2 Additionally the Card should have a button Saying "Show all XXX Comments" where XXX should be replaced with the total comment Count

- It is not necessary to Apply Text Styles yet

**Checklist**
- [ ] Spacings and Sizes are following the [Style Guide](Styleguide.pdf)
- [ ] Comments are Optional
- [ ] Only the latest 2 commments are displayed
- [ ] Show all comments button is only displayed with 3 or more comments
    - _Note:_ there is no need to do anything when clicking the button

### Task 3: Theme - *3P*

Adjust the existing [Theme](src/main/java/fhs/mmt/nma/pixie/ui/theme/Theme.kt) according to the [Style Guide](Styleguide.pdf).

Revisit the PostCard created in Task 1 & 2 and apply all necessary text styles and colors according to the Style Guide

**Checklist**
- [ ] Colors follow [Style Guide](Styleguide.pdf)
- [ ] Theme has a dark and light theme
    - [ ] Enabling Dark Mode in the Android System changes to the dark Variant
- [ ] Typography follows [Style Guide](Styleguide.pdf)
    - [ ] Text elements are styled using the Theme reference
    - _Note:_ the required fonts are already existent in resources

### Task 4: Home Screen - *3P*

Adjust the existing [HomeScreen](src/main/java/fhs/mmt/nma/pixie/ui/home/HomeScreen.kt) according to the [Style Guide](Styleguide.pdf).

- The Screen should contain a _scrollable_ List of all Posts.
- On Top of the Screen there should be a [Toolbar](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#TopAppBar(kotlin.Function0,androidx.compose.ui.Modifier,kotlin.Function0,kotlin.Function1,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,androidx.compose.ui.unit.Dp))
    - When scrolling throuth the Post List, the Toolbar should **not** scroll and remain on top 
- On the Bottom of the Screen there should be a [BottomNavigation](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#BottomNavigation(androidx.compose.ui.Modifier,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,androidx.compose.ui.unit.Dp,kotlin.Function1))
    - When scrolling throuth the Post List, the Bottom Navigation should **not** scroll and remain on the Bottom of the Screen
    - Home is marked as active  

**Checklist**
- [ ] Colors, sizes and spacings follow [Style Guide](Styleguide.pdf)
- [ ] List is implemented via a [LazyList](https://developer.android.com/jetpack/compose/lists#lazy)
    - [ ] List items are spaced using arrangement

### Task 5: Image Loading - *2P* + *2P optional*

Load external Images from the network using [Coil](https://coil-kt.github.io/coil/compose/). 
- Images should be Center Cropped and retain the given Aspect ratio.
- If the Image cannot be loaded for any reason handle the state according to the [Style Guide](Styleguide.pdf)

_Note:_ Posts are still considered to only have one Photo

**Bonus Points**
- While loading Images are displayed using an animated a shimmer [placeholder](https://google.github.io/accompanist/placeholder/#shimmer)

**Checklist**
- [ ] Colors, sizes and spacings follow [Style Guide](Styleguide.pdf)
- [ ] Images are loaded from network using [Coil](https://coil-kt.github.io/coil/compose/)

### Task 4: Timeline Screen - *3P*

Adjust the existing [HomeScreen](src/main/java/fhs/mmt/nma/pixie/ui/home/HomeScreen.kt) according to the [Style Guide](Styleguide.pdf).

- The Screen should contain a _scrollable_ List of all Posts.
- On Top of the Screen there should be a [Toolbar](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#TopAppBar(kotlin.Function0,androidx.compose.ui.Modifier,kotlin.Function0,kotlin.Function1,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,androidx.compose.ui.unit.Dp))
    - When scrolling throuth the Post List, the Toolbar should **not** scroll and remain on top 
- On the Bottom of the Screen there should be a [BottomNavigation](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#BottomNavigation(androidx.compose.ui.Modifier,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,androidx.compose.ui.unit.Dp,kotlin.Function1))
    - When scrolling throuth the Post List, the Bottom Navigation should **not** scroll and remain on the Bottom of the Screen
    - Home is marked as active  

**Checklist**
- [ ] Colors, sizes and spacings follow [Style Guide](Styleguide.pdf)
- [ ] List is implemented via a [LazyList](https://developer.android.com/jetpack/compose/lists#lazy)
    - [ ] List items are spaced using arrangement

### Task 5: Image Gallery - *2P*

Some Posts have more than one Photo. These Posts should have a Swipeable ImageGallery that is swipeable.

- The Gallery should be implemented using the [Pager](https://google.github.io/accompanist/pager/) Component.
- There is a [Indicator](https://google.github.io/accompanist/pager/#indicators) below the Gallery displaying the current active Photo and the total amount of Photos
    - The Indicator is optional and only present if the Post contains multiple Photos

_Note:_ The Indicator in the Top right corner can be ignored for no 

**Checklist**
- [ ] Colors, sizes and spacings follow [Style Guide](Styleguide.pdf)
- [ ] Images are loaded from network using [Coil](https://coil-kt.github.io/coil/compose/)
- [ ] If there are multiple Photos for a Post they are Swipeable
- [ ] There is an indicator indicating the current Page
    - [ ] The Indicator is not visible in the card when there is only one Photo

### Task 5: Custom Page Indicator - *3P*

In Addition to the Dot Indicator there should be another Indicator on the Top right corner of the Image displaying the current active Photo and total Photo amount.

- The Indicator is stationary and should not scroll when the Gallery is swiped
- When Swiping through the Gallery the Indicator should update accordingly

**Checklist**
- [ ] Colors, sizes and spacings follow [Style Guide](Styleguide.pdf)
- [ ] If there are multiple Photos for a Post a custom Indicator is Displayed
- [ ] Indicator reads state from the Pager
    - [ ] When the Pager state changes the Indicatgor is Updated

### Task 6: Navigation - *4P*

The Application should have a [ProfileScreen](src/main/java/fhs/mmt/nma/pixie/ui/profile/ProfileScreen.k) in Addition to the Timeline Screen. Clicking on a UserName or UserAvatar should navigate to the Profile Screen for the clicked User

- Navigation should be done via [compose-navigation](https://developer.android.com/jetpack/compose/navigation)
- Launching the Application should always open the Timeline Screen
- The Profile Screen needs to accept a userId as navigation argument

_Note:_ For this task its only necessary to navigate to anotther Screen. The Screen Content is implemented within Task 7

**Checklist**
- [ ] Colors, sizes and spacings follow [Style Guide](Styleguide.pdf)
- [ ] Navigation is implemented via [compose-navigation](https://developer.android.com/jetpack/compose/navigation)
    - [ ] The Timeline Screen is the Start Destination
    - [ ] The Profile Screen accepts a userId as argument

### Task 7: Profile Screen - *6P*

The User Profile Screen should contain all Elements as defined in the [Style Guide](Styleguide.pdf)

- On Top of the Screen there should be a [Toolbar](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#TopAppBar(kotlin.Function0,androidx.compose.ui.Modifier,kotlin.Function0,kotlin.Function1,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,androidx.compose.ui.unit.Dp)) containing the UserName and a Navigation Icon
    - Clicking the Navigation arrow should invoke a `up` navigation
    - The Toolbar is stationary and should not Scroll
- The Whole Screen Content (except the Toolbar) should be scrollable
- Clicking on the Social Profile should open Instagram with the correct user profile
    - If Instagram is not installed the Web Browser should open up
- The Screen Contains a Gallery displaying all Photos the User has taken
    - The Gallery is displayed as Grid
    - Every Row contains 3 Photos


**Checklist**
- [ ] Colors, sizes and spacings follow [Style Guide](Styleguide.pdf)
- [ ] Whole Screen is Scrollable
    - [ ] Scrolling is Implemented using a [LazyList](https://developer.android.com/jetpack/compose/lists#lazy)
- [ ] Gallery Items width is calculated dynamically with given available screensize