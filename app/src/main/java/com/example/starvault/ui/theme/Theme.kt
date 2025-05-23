package com.example.starvault.ui.theme


import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.starvault.ui.theme.backgroundDark
import com.example.starvault.ui.theme.backgroundDarkHighContrast
import com.example.starvault.ui.theme.backgroundDarkMediumContrast
import com.example.starvault.ui.theme.backgroundLight
import com.example.starvault.ui.theme.backgroundLightHighContrast
import com.example.starvault.ui.theme.backgroundLightMediumContrast
import com.example.starvault.ui.theme.errorContainerDark
import com.example.starvault.ui.theme.errorContainerDarkHighContrast
import com.example.starvault.ui.theme.errorContainerDarkMediumContrast
import com.example.starvault.ui.theme.errorContainerLight
import com.example.starvault.ui.theme.errorContainerLightHighContrast
import com.example.starvault.ui.theme.errorContainerLightMediumContrast
import com.example.starvault.ui.theme.errorDark
import com.example.starvault.ui.theme.errorDarkHighContrast
import com.example.starvault.ui.theme.errorDarkMediumContrast
import com.example.starvault.ui.theme.errorLight
import com.example.starvault.ui.theme.errorLightHighContrast
import com.example.starvault.ui.theme.errorLightMediumContrast
import com.example.starvault.ui.theme.inverseOnSurfaceDark
import com.example.starvault.ui.theme.inverseOnSurfaceDarkHighContrast
import com.example.starvault.ui.theme.inverseOnSurfaceDarkMediumContrast
import com.example.starvault.ui.theme.inverseOnSurfaceLight
import com.example.starvault.ui.theme.inverseOnSurfaceLightHighContrast
import com.example.starvault.ui.theme.inverseOnSurfaceLightMediumContrast
import com.example.starvault.ui.theme.inversePrimaryDark
import com.example.starvault.ui.theme.inversePrimaryDarkHighContrast
import com.example.starvault.ui.theme.inversePrimaryDarkMediumContrast
import com.example.starvault.ui.theme.inversePrimaryLight
import com.example.starvault.ui.theme.inversePrimaryLightHighContrast
import com.example.starvault.ui.theme.inversePrimaryLightMediumContrast
import com.example.starvault.ui.theme.inverseSurfaceDark
import com.example.starvault.ui.theme.inverseSurfaceDarkHighContrast
import com.example.starvault.ui.theme.inverseSurfaceDarkMediumContrast
import com.example.starvault.ui.theme.inverseSurfaceLight
import com.example.starvault.ui.theme.inverseSurfaceLightHighContrast
import com.example.starvault.ui.theme.inverseSurfaceLightMediumContrast
import com.example.starvault.ui.theme.onBackgroundDark
import com.example.starvault.ui.theme.onBackgroundDarkHighContrast
import com.example.starvault.ui.theme.onBackgroundDarkMediumContrast
import com.example.starvault.ui.theme.onBackgroundLight
import com.example.starvault.ui.theme.onBackgroundLightHighContrast
import com.example.starvault.ui.theme.onBackgroundLightMediumContrast
import com.example.starvault.ui.theme.onErrorContainerDark
import com.example.starvault.ui.theme.onErrorContainerDarkHighContrast
import com.example.starvault.ui.theme.onErrorContainerDarkMediumContrast
import com.example.starvault.ui.theme.onErrorContainerLight
import com.example.starvault.ui.theme.onErrorContainerLightHighContrast
import com.example.starvault.ui.theme.onErrorContainerLightMediumContrast
import com.example.starvault.ui.theme.onErrorDark
import com.example.starvault.ui.theme.onErrorDarkHighContrast
import com.example.starvault.ui.theme.onErrorDarkMediumContrast
import com.example.starvault.ui.theme.onErrorLight
import com.example.starvault.ui.theme.onErrorLightHighContrast
import com.example.starvault.ui.theme.onErrorLightMediumContrast
import com.example.starvault.ui.theme.onPrimaryContainerDark
import com.example.starvault.ui.theme.onPrimaryContainerDarkHighContrast
import com.example.starvault.ui.theme.onPrimaryContainerDarkMediumContrast
import com.example.starvault.ui.theme.onPrimaryContainerLight
import com.example.starvault.ui.theme.onPrimaryContainerLightHighContrast
import com.example.starvault.ui.theme.onPrimaryContainerLightMediumContrast
import com.example.starvault.ui.theme.onPrimaryDark
import com.example.starvault.ui.theme.onPrimaryDarkHighContrast
import com.example.starvault.ui.theme.onPrimaryDarkMediumContrast
import com.example.starvault.ui.theme.onPrimaryLight
import com.example.starvault.ui.theme.onPrimaryLightHighContrast
import com.example.starvault.ui.theme.onPrimaryLightMediumContrast
import com.example.starvault.ui.theme.onSecondaryContainerDark
import com.example.starvault.ui.theme.onSecondaryContainerDarkHighContrast
import com.example.starvault.ui.theme.onSecondaryContainerDarkMediumContrast
import com.example.starvault.ui.theme.onSecondaryContainerLight
import com.example.starvault.ui.theme.onSecondaryContainerLightHighContrast
import com.example.starvault.ui.theme.onSecondaryContainerLightMediumContrast
import com.example.starvault.ui.theme.onSecondaryDark
import com.example.starvault.ui.theme.onSecondaryDarkHighContrast
import com.example.starvault.ui.theme.onSecondaryDarkMediumContrast
import com.example.starvault.ui.theme.onSecondaryLight
import com.example.starvault.ui.theme.onSecondaryLightHighContrast
import com.example.starvault.ui.theme.onSecondaryLightMediumContrast
import com.example.starvault.ui.theme.onSurfaceDark
import com.example.starvault.ui.theme.onSurfaceDarkHighContrast
import com.example.starvault.ui.theme.onSurfaceDarkMediumContrast
import com.example.starvault.ui.theme.onSurfaceLight
import com.example.starvault.ui.theme.onSurfaceLightHighContrast
import com.example.starvault.ui.theme.onSurfaceLightMediumContrast
import com.example.starvault.ui.theme.onSurfaceVariantDark
import com.example.starvault.ui.theme.onSurfaceVariantDarkHighContrast
import com.example.starvault.ui.theme.onSurfaceVariantDarkMediumContrast
import com.example.starvault.ui.theme.onSurfaceVariantLight
import com.example.starvault.ui.theme.onSurfaceVariantLightHighContrast
import com.example.starvault.ui.theme.onSurfaceVariantLightMediumContrast
import com.example.starvault.ui.theme.onTertiaryContainerDark
import com.example.starvault.ui.theme.onTertiaryContainerDarkHighContrast
import com.example.starvault.ui.theme.onTertiaryContainerDarkMediumContrast
import com.example.starvault.ui.theme.onTertiaryContainerLight
import com.example.starvault.ui.theme.onTertiaryContainerLightHighContrast
import com.example.starvault.ui.theme.onTertiaryContainerLightMediumContrast
import com.example.starvault.ui.theme.onTertiaryDark
import com.example.starvault.ui.theme.onTertiaryDarkHighContrast
import com.example.starvault.ui.theme.onTertiaryDarkMediumContrast
import com.example.starvault.ui.theme.onTertiaryLight
import com.example.starvault.ui.theme.onTertiaryLightHighContrast
import com.example.starvault.ui.theme.onTertiaryLightMediumContrast
import com.example.starvault.ui.theme.outlineDark
import com.example.starvault.ui.theme.outlineDarkHighContrast
import com.example.starvault.ui.theme.outlineDarkMediumContrast
import com.example.starvault.ui.theme.outlineLight
import com.example.starvault.ui.theme.outlineLightHighContrast
import com.example.starvault.ui.theme.outlineLightMediumContrast
import com.example.starvault.ui.theme.outlineVariantDark
import com.example.starvault.ui.theme.outlineVariantDarkHighContrast
import com.example.starvault.ui.theme.outlineVariantDarkMediumContrast
import com.example.starvault.ui.theme.outlineVariantLight
import com.example.starvault.ui.theme.outlineVariantLightHighContrast
import com.example.starvault.ui.theme.outlineVariantLightMediumContrast
import com.example.starvault.ui.theme.primaryContainerDark
import com.example.starvault.ui.theme.primaryContainerDarkHighContrast
import com.example.starvault.ui.theme.primaryContainerDarkMediumContrast
import com.example.starvault.ui.theme.primaryContainerLight
import com.example.starvault.ui.theme.primaryContainerLightHighContrast
import com.example.starvault.ui.theme.primaryContainerLightMediumContrast
import com.example.starvault.ui.theme.primaryDark
import com.example.starvault.ui.theme.primaryDarkHighContrast
import com.example.starvault.ui.theme.primaryDarkMediumContrast
import com.example.starvault.ui.theme.primaryLight
import com.example.starvault.ui.theme.primaryLightHighContrast
import com.example.starvault.ui.theme.primaryLightMediumContrast
import com.example.starvault.ui.theme.scrimDark
import com.example.starvault.ui.theme.scrimDarkHighContrast
import com.example.starvault.ui.theme.scrimDarkMediumContrast
import com.example.starvault.ui.theme.scrimLight
import com.example.starvault.ui.theme.scrimLightHighContrast
import com.example.starvault.ui.theme.scrimLightMediumContrast
import com.example.starvault.ui.theme.secondaryContainerDark
import com.example.starvault.ui.theme.secondaryContainerDarkHighContrast
import com.example.starvault.ui.theme.secondaryContainerDarkMediumContrast
import com.example.starvault.ui.theme.secondaryContainerLight
import com.example.starvault.ui.theme.secondaryContainerLightHighContrast
import com.example.starvault.ui.theme.secondaryContainerLightMediumContrast
import com.example.starvault.ui.theme.secondaryDark
import com.example.starvault.ui.theme.secondaryDarkHighContrast
import com.example.starvault.ui.theme.secondaryDarkMediumContrast
import com.example.starvault.ui.theme.secondaryLight
import com.example.starvault.ui.theme.secondaryLightHighContrast
import com.example.starvault.ui.theme.secondaryLightMediumContrast
import com.example.starvault.ui.theme.surfaceBrightDark
import com.example.starvault.ui.theme.surfaceBrightDarkHighContrast
import com.example.starvault.ui.theme.surfaceBrightDarkMediumContrast
import com.example.starvault.ui.theme.surfaceBrightLight
import com.example.starvault.ui.theme.surfaceBrightLightHighContrast
import com.example.starvault.ui.theme.surfaceBrightLightMediumContrast
import com.example.starvault.ui.theme.surfaceContainerDark
import com.example.starvault.ui.theme.surfaceContainerDarkHighContrast
import com.example.starvault.ui.theme.surfaceContainerDarkMediumContrast
import com.example.starvault.ui.theme.surfaceContainerHighDark
import com.example.starvault.ui.theme.surfaceContainerHighDarkHighContrast
import com.example.starvault.ui.theme.surfaceContainerHighDarkMediumContrast
import com.example.starvault.ui.theme.surfaceContainerHighLight
import com.example.starvault.ui.theme.surfaceContainerHighLightHighContrast
import com.example.starvault.ui.theme.surfaceContainerHighLightMediumContrast
import com.example.starvault.ui.theme.surfaceContainerHighestDark
import com.example.starvault.ui.theme.surfaceContainerHighestDarkHighContrast
import com.example.starvault.ui.theme.surfaceContainerHighestDarkMediumContrast
import com.example.starvault.ui.theme.surfaceContainerHighestLight
import com.example.starvault.ui.theme.surfaceContainerHighestLightHighContrast
import com.example.starvault.ui.theme.surfaceContainerHighestLightMediumContrast
import com.example.starvault.ui.theme.surfaceContainerLight
import com.example.starvault.ui.theme.surfaceContainerLightHighContrast
import com.example.starvault.ui.theme.surfaceContainerLightMediumContrast
import com.example.starvault.ui.theme.surfaceContainerLowDark
import com.example.starvault.ui.theme.surfaceContainerLowDarkHighContrast
import com.example.starvault.ui.theme.surfaceContainerLowDarkMediumContrast
import com.example.starvault.ui.theme.surfaceContainerLowLight
import com.example.starvault.ui.theme.surfaceContainerLowLightHighContrast
import com.example.starvault.ui.theme.surfaceContainerLowLightMediumContrast
import com.example.starvault.ui.theme.surfaceContainerLowestDark
import com.example.starvault.ui.theme.surfaceContainerLowestDarkHighContrast
import com.example.starvault.ui.theme.surfaceContainerLowestDarkMediumContrast
import com.example.starvault.ui.theme.surfaceContainerLowestLight
import com.example.starvault.ui.theme.surfaceContainerLowestLightHighContrast
import com.example.starvault.ui.theme.surfaceContainerLowestLightMediumContrast
import com.example.starvault.ui.theme.surfaceDark
import com.example.starvault.ui.theme.surfaceDarkHighContrast
import com.example.starvault.ui.theme.surfaceDarkMediumContrast
import com.example.starvault.ui.theme.surfaceDimDark
import com.example.starvault.ui.theme.surfaceDimDarkHighContrast
import com.example.starvault.ui.theme.surfaceDimDarkMediumContrast
import com.example.starvault.ui.theme.surfaceDimLight
import com.example.starvault.ui.theme.surfaceDimLightHighContrast
import com.example.starvault.ui.theme.surfaceDimLightMediumContrast
import com.example.starvault.ui.theme.surfaceLight
import com.example.starvault.ui.theme.surfaceLightHighContrast
import com.example.starvault.ui.theme.surfaceLightMediumContrast
import com.example.starvault.ui.theme.surfaceVariantDark
import com.example.starvault.ui.theme.surfaceVariantDarkHighContrast
import com.example.starvault.ui.theme.surfaceVariantDarkMediumContrast
import com.example.starvault.ui.theme.surfaceVariantLight
import com.example.starvault.ui.theme.surfaceVariantLightHighContrast
import com.example.starvault.ui.theme.surfaceVariantLightMediumContrast
import com.example.starvault.ui.theme.tertiaryContainerDark
import com.example.starvault.ui.theme.tertiaryContainerDarkHighContrast
import com.example.starvault.ui.theme.tertiaryContainerDarkMediumContrast
import com.example.starvault.ui.theme.tertiaryContainerLight
import com.example.starvault.ui.theme.tertiaryContainerLightHighContrast
import com.example.starvault.ui.theme.tertiaryContainerLightMediumContrast
import com.example.starvault.ui.theme.tertiaryDark
import com.example.starvault.ui.theme.tertiaryDarkHighContrast
import com.example.starvault.ui.theme.tertiaryDarkMediumContrast
import com.example.starvault.ui.theme.tertiaryLight
import com.example.starvault.ui.theme.tertiaryLightHighContrast
import com.example.starvault.ui.theme.tertiaryLightMediumContrast

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun StarVaultTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      
      darkTheme -> darkScheme
      else -> lightScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
  )
}

