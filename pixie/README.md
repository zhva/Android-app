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

## Required Tasks

All Tasks are worth a total of **30** Points

### Task 1: Post Card - *4P*

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

### Task 2: Comments - *3P*

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

### Task 6: Image Gallery - *2P*

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

### Task 7: Custom Page Indicator - *3P*

In Addition to the Dot Indicator there should be another Indicator on the Top right corner of the Image displaying the current active Photo and total Photo amount.

- The Indicator is stationary and should not scroll when the Gallery is swiped
- When Swiping through the Gallery the Indicator should update accordingly

**Checklist**
- [ ] Colors, sizes and spacings follow [Style Guide](Styleguide.pdf)
- [ ] If there are multiple Photos for a Post a custom Indicator is Displayed
- [ ] Indicator reads state from the Pager
    - [ ] When the Pager state changes the Indicatgor is Updated

### Task 8: Navigation - *4P*

The Application should have a [ProfileScreen](src/main/java/fhs/mmt/nma/pixie/ui/profile/ProfileScreen.k) in Addition to the Timeline Screen. Clicking on a UserName or UserAvatar should navigate to the Profile Screen for the clicked User

- Navigation should be done via [compose-navigation](https://developer.android.com/jetpack/compose/navigation)
- Launching the Application should always open the Timeline Screen
- The Profile Screen needs to accept a userId as navigation argument

_Note:_ For this task its only necessary to navigate to another Screen. The Screen Content is implemented within Task 7

**Checklist**
- [ ] Colors, sizes and spacings follow [Style Guide](Styleguide.pdf)
- [ ] Navigation is implemented via [compose-navigation](https://developer.android.com/jetpack/compose/navigation)
    - [ ] The Timeline Screen is the Start Destination
    - [ ] The Profile Screen accepts a userId as argument

### Task 9: Profile Screen - *6P*

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

## Optional Tasks

The Following Tasks are optional and not required for passing the course. The Additional Tasks are worth a total of **20** Points

### Task 10: ViewModel on Home - *5P*

The Home Screen should use a ViewModel and expose all Posts as member property

- The instance of the ViewModel should be created using the `viewModel()` composable function in the navigation graph


**Checklist**
- [ ] HomeViewModel extends `androidx.lifecycle.ViewModel`
- [ ] HomeViewModel is created using `viewModel()` composable function
- [ ] HomeViewModel defines a property for all Available Posts
    - [ ] the Composable reads the property from the given ViewModel


### Task 11: ViewModel on Profile - *5P*

The Profile Screen should use a ViewModel and expose data using a remodeled UI Data class

- The required data should be put into a new `data class` 
- The userId needs to be read inside the viewmodel
    - This is archivable by accepting a `SavedStateHandle` as constructor argument in the ViewModel and by scoping the viewmodel to the backstack entry

**Checklist**
- [ ] ProfileViewModel extends `androidx.lifecycle.ViewModel`
- [ ] ProfileViewModel is created using `viewModel()` composable function
    - [ ] the viewmodel is scoped to the backstack entry
- [ ] ProfileViewModel defines a property for all Required Data
    - [ ] the Composable reads the property from the given ViewModel
    - [ ] the data is captured in a seperate `data class` 

### Task 12: MVI on Home - *10P* + *3P*

The Home Screen should use a MVI Architecture defining the UiState, SideEffects and Events

- The exposed UiState from the ViewModel should be a `androidx.compose.runtime.State`
    - Inside the ViewModel it can be a `androidx.compose.runtime.MutableState`
- Instead of directly defining Click Action logic, Events should be send to the ViewModel
    - The Events in the ViewModel should be a `MutableSharedFlow` and consumed only by the viewmodel
- The ViewModel exposes effects that the composable should react to
    - One of these effects is the navigation to another screen
    - The Effects should be of type `Flow<Effect>`


**Checklist**
- [ ] HomeViewModel has a `State` property containing the UiState
- [ ] HomeViewModel has a `Flow<Effect>` property publishing Effects to the Composable
    - [ ] The Composable consumes them using `LaunchedEffect`
- [ ] HomeViewModel offers a function to send Events
    - [ ] every Event is added to the private `MutableSharedFlow`
- [ ] HomeScreen sends an Event to the ViewModel when a user is Clicked
    - [ ] The Event takes enough information to identify wich user was clicked
- [ ] HomeViewModel Subscribes to Events and handles every event
- [ ] HomeViewModel sends a Effect for navigation when a User Clicked Event is send


**Bonus Points**
- HomeScreen uses state hoisting 
    - The hoisted HomeScreen has no references to the ViewModel directly 

### Task 12: MVI on Profile - *10P*  + *5P*

The Profile Screen should use a MVI Architecture defining the UiState, SideEffects and Events

- The UiState should be capable of modeling 3 states
    - Loading State
    - Content State
    - Error State
- If the userId cannot be extracted from the given SavedStateHandle the UiState should be Error
- If there is no User for given userId the UiState should be Error
- The exposed UiState from the ViewModel should be a `androidx.compose.runtime.State`
    - Inside the ViewModel it can be a `androidx.compose.runtime.MutableState`
- Instead of directly defining Click Action logic, Events should be send to the ViewModel
    - The Events in the ViewModel should be a `MutableSharedFlow` and consumed only by the viewmodel
- The ViewModel exposes effects that the composable should react to
    - The Effects should be of type `Flow<Effect>`


**Checklist**
- [ ] ProfileViewModel has a `State` property containing the UiState
- [ ] The Ui State is modeled using a `sealed class`
- [ ] ProfileViewModel has a `Flow<Effect>` property publishing Effects to the Composable
    - [ ] The Composable consumes them using `LaunchedEffect`
- [ ] ProfileViewModel offers a function to send Events
    - [ ] every Event is added to the private `MutableSharedFlow`
- [ ] HomeScreen sends an Event to the ViewModel when a user is Clicked
    - [ ] The Event takes enough information to identify wich user was clicked
- [ ] ProfileViewModel Subscribes to Events and handles every event
- [ ] ProfileViewModel sends a Effect for navigation when a User Clicked Event is send

**Bonus Points**
- ProfileScreen uses state hoisting 
    - The hoisted ProfileScreen(s) have no references to the ViewModel directly 
    - There are Previews available for all possible (hoisted) UI States