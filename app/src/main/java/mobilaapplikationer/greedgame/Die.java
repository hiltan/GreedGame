package mobilaapplikationer.greedgame;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageButton;

import java.util.Random;

import uppgift1.greed.R;

/**
 * The die class represents a die that has a value and some parameters
 * that tells whether the die is on hold, locked and give points or not.
 */
public class Die extends ImageButton implements Parcelable{
    int value;
    boolean locked = false;
    boolean onHold = false;
    boolean givePoints = false;

    /**
     * Getter for the locked variable.
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * Set give point true.
     */
    public void setGivePoints () {
        this.givePoints = true;
    }

    /**
     * Set give points false.
     */
    public void setNoPoints() {
        this.givePoints = false;
    }

    /**
     * Sets locked true and updates the skin of the die in the UI accordingly.
     */
    public void setLocked() {
        this.locked = true;
        setRed(value);
    }

    /**
     * Sets the die values and variables.
     */
    public void setOldValues(int value, boolean locked, boolean onHold, boolean givePoints) {
        this.value = value;
        this.locked = locked;
        this.onHold = onHold;
        this.givePoints = givePoints;
        if(locked) {
            setRed(this.value);
        } else if(onHold) {
            setGrey(this.value);
        } else {
            setWhite(this.value);
        }
    }

    /**
     * Sets the die locked variable to false and uppdates the skin in the UI
     * accordingly.
     */
    public void setUnlocked() {
        this.locked = false;
        setWhite(value);
    }

    /**
     * Contructor for the die class.
     */
    public Die(Context context) {
        super(context);
    }

    /**
     * Contructor for the die class.
     */
    public Die(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /**
     * Contructor for the die class.
     */
    public Die(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
    }

    /**
     * Switches the on hold variable between true and false and updates
     * the skin in the UI accordingly.
     */
    public void changeOnHold() {
        if (!onHold) {
            onHold = true;
            setGrey(value);
        }
        else {
            onHold = false;
            setWhite(value);
        }

    }

    /**
     * Rolls the die getting a random variable between 1 and 6 and updates the
     * skin and on hold variable.
     */
    public void rollDie() {
        Random randomGenerator = new Random();
        value = randomGenerator.nextInt(6) + 1;
        setWhite(value);
        onHold = false;
    }

    /**
     * Updates the skin in the UI to the white skin with the number of dots
     * that the given value has. Skins are available for values from 1 to 6.
     */
    public void setWhite(int value) {
        if(value==1) {
            setImageResource(R.drawable.white1);
        } else if(value==2) {
            setImageResource(R.drawable.white2);
        }else if(value==3) {
            setImageResource(R.drawable.white3);
        }else if(value==4) {
            setImageResource(R.drawable.white4);
        }else if(value==5) {
            setImageResource(R.drawable.white5);
        }else if(value==6) {
            setImageResource(R.drawable.white6);
        }
    }

    /**
     * Updates the skin in the UI to the grey skin with the number of dots
     * that the given value has. Skins are available for values from 1 to 6.
     */
    public void setGrey(int value) {
        if(value==1) {
            setImageResource(R.drawable.grey1);
        } else if(value==2) {
            setImageResource(R.drawable.grey2);
        }else if(value==3) {
            setImageResource(R.drawable.grey3);
        }else if(value==4) {
            setImageResource(R.drawable.grey4);
        }else if(value==5) {
            setImageResource(R.drawable.grey5);
        }else if(value==6) {
            setImageResource(R.drawable.grey6);
        }
    }

    /**
     * Updates the skin in the UI to the red skin with the number of dots
     * that the given value has. Skins are available for values from 1 to 6.
     */
    public void setRed(int value) {
        if(value==1) {
            setImageResource(R.drawable.red1);
        } else if(value==2) {
            setImageResource(R.drawable.red2);
        }else if(value==3) {
            setImageResource(R.drawable.red3);
        }else if(value==4) {
            setImageResource(R.drawable.red4);
        }else if(value==5) {
            setImageResource(R.drawable.red5);
        }else if(value==6) {
            setImageResource(R.drawable.red6);
        }
    }

    /**
     * Getter for the value variable.
     */
    public int getValue(){
        return value;
    }

    /**
     * Method required for the class to be parcelable.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Writes the values to a parcel for saving between instances.
     */
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(value);
        parcel.writeValue(locked);
        parcel.writeValue(onHold);
        parcel.writeValue(givePoints);
    }

    /**
     * Constructor for the die used when recreating it from a parcel.
     */
    private Die(Parcel in) {
        super(null);

        value = in.readInt();
        locked = (Boolean) in.readValue( null );
        onHold = (Boolean) in.readValue( null );
        givePoints = (Boolean) in.readValue( null );
    }

    /**
     * Method used to create die. Needed to be parcelable.
     */
    public static final Parcelable.Creator<Die> CREATOR
            = new Parcelable.Creator<Die>() {
        public Die createFromParcel(Parcel in) {
            return new Die(in);
        }

        public Die[] newArray(int size) {
            return new Die[size];
        }
    };
}
