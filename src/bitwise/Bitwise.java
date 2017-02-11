public class Bitwise {
	
	public static void main(String[] args){
		Setting setting = new Setting();
        setting.on(Setting.ONE);
        setting.on(Setting.FIVE);
        setting.on(Setting.TWO);
        System.out.println(setting.toString());
        System.out.println(setting.isOn(Setting.FIVE));
        System.out.println(setting.isOn(Setting.TWO));
        setting.off(Setting.TWO);
        System.out.println(setting.isOn(Setting.TWO));
        setting.toggle(Setting.TWO);
        System.out.println(setting.isOn(Setting.TWO));
        setting.toggle(Setting.TWO);
        System.out.println(setting.isOn(Setting.TWO));
        int saved = setting.get();
        Setting renew = new Setting(saved);
        renew.allOff();
        renew.on(Setting.EIGHT);
        renew.on(Setting.EIGHT, Setting.POSITION_TW0);
        renew.on(Setting.EIGHT, Setting.POSITION_THREE);
        renew.on(Setting.EIGHT, Setting.POSITION_FOUR);
        System.out.println(renew.toString());
        renew.off(Setting.EIGHT, Setting.POSITION_FOUR);
        System.out.println(renew.toString());
        renew.toggle(Setting.EIGHT, Setting.POSITION_FOUR);
        System.out.println(renew.toString());
        renew.toggle(Setting.EIGHT, Setting.POSITION_FOUR);
        System.out.println(renew.toString());
        renew.on(Setting.FIVE);
        System.out.println(renew.isOn(Setting.FIVE));
        System.out.println(renew.isOn(Setting.EIGHT, Setting.POSITION_THREE));
	}

    private static class Setting{

        public static final int EMPTY = 0x00000000;
        public static final int ONE = 0x00000001;
        public static final int TWO = 0x00000002;
        public static final int THREE = 0x00000004;
        public static final int FOUR = 0x0000008;
        public static final int FIVE = 0x00000010;
        public static final int SIX = 0x00000020;
        public static final int SEVEN = 0x00000040;
        public static final int EIGHT = 0x00000080;

        public static final int POSITION_ONE = 0x00000000;
        public static final int POSITION_TW0 = 0x00000008;
        public static final int POSITION_THREE = 0x0000010;
        public static final int POSITION_FOUR = 0x00000018;

        private int mSetting = EMPTY;

        public Setting(){}

        public Setting(int setting){
            allOff();
            mSetting |= setting;
        }

        public void on(int setting){
            mSetting |= setting;
        }

        public void on(int setting, int position){
            mSetting |= (setting << position);
        }

        public void off(int setting){
            mSetting &= ~setting;
        }

        public void off(int setting, int position){
            mSetting &= ~(setting << position);
        }

        public void toggle(int setting){
            mSetting ^= setting;
        }

        public void toggle(int setting, int position){
            mSetting ^= (setting << position);
        }

        public void allOff(){
            mSetting &= EMPTY;
        }

        public boolean isOn(int setting){
            return (mSetting & setting) != 0;
        }

        public boolean isOn(int setting, int position){
            return (mSetting & (setting << position)) != 0;
        }

        public boolean isOff(int setting){
            return !isOn(setting);
        }

        public boolean isOff(int setting, int position){
            return !isOn(setting, position);
        }

        public int get(){
            return mSetting;
        }

        @Override
        public String toString(){
            return String.format("%32s", Integer.toBinaryString(get())).replace(" ", "0");
        }
    }
	
}