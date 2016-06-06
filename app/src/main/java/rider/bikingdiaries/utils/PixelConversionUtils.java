package rider.bikingdiaries.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import rider.bikingdiaries.activity.BikingDiaries;
import rider.bikingdiaries.constants.AppConstants;

/**
 * Created by akashb on 4/8/15.
 */
public class PixelConversionUtils {

    public static final float MARGIN_BETWEEN_CARD_TAB_SCREEN_PERCENT = 0.02f;
    public static final float MARGIN_BETWEEN_CARD_PHONE_SCREEN_PERCENT = 0.03f;
    public static final float MARGIN_WITHIN_CARD_TAB_SCREEN_PERCENT = 0.02f;
    public static final float MARGIN_WITHIN_CARD_PHONE_SCREEN_PERCENT = 0.03f;
    private static final String TAG = PixelConversionUtils.class.getSimpleName();

    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public static float convertDpToPixel(float dp) {
        Resources resources = BikingDiaries.getInstance().getApplicationContext().getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return px;
    }

    public static int convertDpToPixelInt(float dp) {

        DisplayMetrics metrics = BikingDiaries.getInstance().getApplicationContext().getResources().getDisplayMetrics();
        int px = (int) (dp * (metrics.densityDpi / 160f));
        return px;
    }


    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px A value in px (pixels) unit. Which we need to convert into db
     * @return A float value to represent dp equivalent to px value
     */
    public static float convertPixelsToDp(float px) {
        Resources resources = BikingDiaries.getInstance().getApplicationContext().getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / (metrics.densityDpi / 160f);
        return dp;
    }


    public static float converticalVerticalPixels(float givenPixels) {
        float dp = 0;
        float division = givenPixels / PixelConstants.REFERENCE_HEIGHT;
        dp = division * AppConstants.DEVICE_HEIGHT;
        return dp;

    }

    public static float converticalHorizontalPixels(float givenPixels) {
        float dp = 0;
        float division = givenPixels / PixelConstants.REFERENCE_WIDTH;
        dp = division * AppConstants.DEVICE_WIDTH;
        return dp;

    }


    public static void setIcon(View container, int padding) {

        int iconContainerSize = getListCardIconWidth();

        ViewGroup.MarginLayoutParams containerParams = (ViewGroup.MarginLayoutParams) container
                .getLayoutParams();
        containerParams.height = iconContainerSize;
        containerParams.width = iconContainerSize;
        container.setPadding(padding, padding, padding, padding);
    }





    public static ImageView setOpenListIcon(View container, ImageView appIcon, int padding) {

        ImageView imageView = null;
        int iconContainerSize = getOpenListCardIconWidth();

        ViewGroup.MarginLayoutParams containerParams = (ViewGroup.MarginLayoutParams) container
                .getLayoutParams();
        containerParams.height = iconContainerSize;
        containerParams.width = iconContainerSize;
        container.setPadding(padding, padding, padding, padding);

        return imageView;
    }

    public static void setSpecialCloseIcon(View parent, AppConstants.GRID_TYPE gridType) {

        final ViewGroup.MarginLayoutParams containerParams = (ViewGroup.MarginLayoutParams) parent
                .getLayoutParams();

        if (gridType == AppConstants.GRID_TYPE.SPECIAL_CLOSE) {
            int WIDTH = (int) (AppConstants.DEVICE_WIDTH * 0.45);
            containerParams.height = (int) (WIDTH / 1.66);
        }
    }

    public static void setGridIcon(View appIcon, AppConstants.GRID_TYPE gridType, int padding) {

        int iconSize = 200;
        if (gridType == AppConstants.GRID_TYPE.GRID_2) {
            iconSize = (int) (((AppConstants.DEVICE_WIDTH - (padding * 7)) / 2));

        } else if (gridType == AppConstants.GRID_TYPE.GRID_3) {
            iconSize = (int) (((AppConstants.DEVICE_WIDTH - (padding * 10)) / 3));
        }

        ViewGroup.MarginLayoutParams containerParams = (ViewGroup.MarginLayoutParams) appIcon
                .getLayoutParams();

        containerParams.width = iconSize;
        containerParams.height = iconSize;
    }


    public static void setHomepageBanner(View viewPager, double division) {

        int iconContainerSize = (int) ((AppConstants.DEVICE_WIDTH / division));

        ViewGroup.MarginLayoutParams containerParams = (ViewGroup.MarginLayoutParams) viewPager
                .getLayoutParams();
        containerParams.height = iconContainerSize;
    }




    private static int getListCardIconWidth() {

        int cardwidth = 0;
        if (AppConstants.DEVICE_WIDTH >
                AppConstants.INT_720_WIDTH) {
            cardwidth = (int) ((AppConstants.DEVICE_WIDTH * 0.40));
        } else if (AppConstants.DEVICE_WIDTH <
                AppConstants.INT_720_WIDTH) {
            cardwidth = (int) ((AppConstants.DEVICE_WIDTH * 0.40));
        } else {
            cardwidth = (int) ((AppConstants.DEVICE_WIDTH * 0.40));
        }
        return cardwidth;
    }


    private static int getOpenListCardIconWidth() {

        int cardwidth = 0;
        if (AppConstants.DEVICE_WIDTH >
                AppConstants.INT_720_WIDTH) {
            cardwidth = (int) ((AppConstants.DEVICE_WIDTH * 0.20));
        } else if (AppConstants.DEVICE_WIDTH <
                AppConstants.INT_720_WIDTH) {
            cardwidth = (int) ((AppConstants.DEVICE_WIDTH * 0.20));
        } else {
            cardwidth = (int) ((AppConstants.DEVICE_WIDTH * 0.20));
        }
        return cardwidth;
    }


    /*public static void applyGridButtonProperties(View... button) {
        if (null != button) {
            for (View btn : button) {
                if (btn != null) {
                    setPaddingWithinFreeButton(btn);
                }
            }

        }
    }

    public static void applyBiggerButtonProperties(View... button) {
        if (null != button) {
            for (View btn : button) {
                if (btn != null) {
                    setPaddingWithinFreeButton(button);
                    ViewGroup.MarginLayoutParams buttonParams = (ViewGroup.MarginLayoutParams) btn
                            .getLayoutParams();
                    buttonParams.width = (int) (AppConstants.DEVICE_WIDTH * 0.25);
                }
            }
        }
    }*/

    /*public static void applyDownloadButtonProperties(ViewGroup txtButton) {
        if (null != txtButton) {
            setDownloadButtonWidth(txtButton);
            txtButton.findViewById(R.id.tv_button_text).setPadding(0, AppConstants.PADDING_8, 0, AppConstants.PADDING_8);
            txtButton.findViewById(R.id.img_download).setPadding(AppConstants.PADDING_8, 0, AppConstants.PADDING_8, 0);
        }
    }

    public static void applyDetailButtonProperties(ViewGroup txtButton){
        if (null != txtButton) {
            setDownloadButtonWidthForDetailPage(txtButton);
            txtButton.findViewById(R.id.tv_button_text).setPadding(0, AppConstants.PADDING_8, 0, AppConstants.PADDING_8);
            txtButton.findViewById(R.id.img_download).setPadding(AppConstants.PADDING_8, 0, AppConstants.PADDING_8, 0);
        }
    }*/

    public static void setDownloadButtonWidth(ViewGroup txtButton){
        ViewGroup.MarginLayoutParams buttonParams = (ViewGroup.MarginLayoutParams) txtButton
                .getLayoutParams();
        buttonParams.width = (int) (AppConstants.DEVICE_WIDTH * 0.28);
    }

    public static void setDownloadButtonWidthForDetailPage(ViewGroup txtButton){
        ViewGroup.MarginLayoutParams buttonParams = (ViewGroup.MarginLayoutParams) txtButton
                .getLayoutParams();
        buttonParams.width = (int) (AppConstants.DEVICE_WIDTH * 0.32);
    }


    /*public static void applyCarouselButtonProperties(View... button) {
        if (null != button) {
            for (View btn : button) {
                if (btn != null) {
                    setPaddingWithinFreeButton(button);
                    ViewGroup.MarginLayoutParams buttonParams = (ViewGroup.MarginLayoutParams) btn
                            .getLayoutParams();
                    buttonParams.width = (int) (AppConstants.DEVICE_WIDTH * 0.30);
                }
            }
        }
    }*/



    /*public static void applyBiggestButtonProperties(View... button) {
        if (null != button) {
            for (View btn : button) {
                if (btn != null) {
                    //setPaddingWithinFreeButton(button);

                    int paddingWithinButton = getPaddingWithinButton();
                    btn.setPadding(paddingWithinButton, paddingWithinButton, paddingWithinButton, paddingWithinButton);

                    ViewGroup.MarginLayoutParams buttonParams = (ViewGroup.MarginLayoutParams) btn
                            .getLayoutParams();
                    // buttonParams.width = (int) (AppConstants.DEVICE_WIDTH);
                    buttonParams.width = ViewGroup.MarginLayoutParams.WRAP_CONTENT;
                }
            }
        }
    }


    public static void applyFreeButtonProperties(View... button) {
        if (null != button) {
            for (View btn : button) {
                if (btn != null) {
                    setPaddingWithinFreeButton(btn);
                    ViewGroup.MarginLayoutParams buttonParams = (ViewGroup.MarginLayoutParams) btn
                            .getLayoutParams();
                    buttonParams.width = (int) (AppConstants.DEVICE_WIDTH * 0.23);//PixelConversionUtils.convertDpToPixelInt(Mobango.getContext(), 64) ;//(int)(cardWidth * 0.6f);
                }
            }
        }
    }*/


   /* public static void setPaddingWithinFreeButton(View... freeButton) {
        if (null != freeButton) {
            for (View freebtn : freeButton) {
                if (freebtn != null) {
                    int paddingWithinButton = getPaddingWithinButton();
                    int spacingWithinCard = getSpacingWithinCard();
                    freebtn.setPadding(paddingWithinButton / 6, paddingWithinButton, paddingWithinButton - spacingWithinCard, paddingWithinButton);

                    AppConstants.log(TAG, " setPaddingWithinFreeButton ("+ ( paddingWithinButton / 6 )
                            + "," + ( paddingWithinButton ) + ","
                            + "," + ( paddingWithinButton - spacingWithinCard ) + ","
                            + "," + ( paddingWithinButton ) + ","
                            + ")");
                }
            }
        }
    }

    public static int getPaddingWithinButton() {
        return (int) (getSpacingBetweenCards() * 0.62);
    }*/

    /*public static int getSpacingWithinCard() {
        final float screenPercent;
        if (AppUtility.isTablet(BikingDiaries.getInstance().getAppContext())) {
            screenPercent = MARGIN_WITHIN_CARD_TAB_SCREEN_PERCENT;
        } else {
            screenPercent = MARGIN_WITHIN_CARD_PHONE_SCREEN_PERCENT;
        }
        int spacingWithinCard = (int) (screenPercent * AppConstants.DEVICE_WIDTH);
        return spacingWithinCard;
    }

    public static int getSpacingBetweenCards() {
        final float screenPercent;
        if (AppUtility.isTablet(BikingDiaries.getInstance().getAppContext())) {
            screenPercent = MARGIN_BETWEEN_CARD_TAB_SCREEN_PERCENT;
        } else {
            screenPercent = MARGIN_BETWEEN_CARD_PHONE_SCREEN_PERCENT;
        }
        int spacingbetweenCards = (int) (screenPercent * AppConstants.DEVICE_WIDTH);
        return spacingbetweenCards;
    }*/


    /*public static void setPaddingInSeeMoreButton(View... freeButton) {
        if (null != freeButton) {
            for (View freebtn : freeButton) {
                if (freebtn != null) {
                    int paddingWithinButton = getPaddingWithinButton();
                    int spacingWithinCard = getSpacingWithinCard();
                    freebtn.setPadding(paddingWithinButton, paddingWithinButton * 2, paddingWithinButton, paddingWithinButton * 2);
                }
            }
        }
    }*/

    public static int getHugeIconSize() {
        return 0;
    }

    private static float getFontScale() {
        //huge = 1.3, small = 1.0, normal = 1.1, large = 1.2 for HTC
        return BikingDiaries.getInstance().getResources().getConfiguration().fontScale;
    }

    public static boolean isLargeSystemFontSize() {
        boolean isLargeFont = false;
        float normalSize = (float) 1.1;
        int result = Float.compare(getFontScale(), normalSize);
        if (result > 0 || result == 0) {
            isLargeFont = true;
        }
        return isLargeFont;
    }

    public static void setVideoThumbnail(final View view, final int width) {
        int height = (int) ((width * 9) / 16);
        ViewGroup.MarginLayoutParams containerParams = (ViewGroup.MarginLayoutParams) view
                .getLayoutParams();
        containerParams.height = height;
    }
}
