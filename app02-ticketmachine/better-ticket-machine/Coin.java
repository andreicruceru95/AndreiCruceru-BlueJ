public enum Coin
    {
        P10 (10),
        P20 (20),
        P100 (100),
        P200 (200);

        public final int value;

        private Coin(int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return value;
        }
     }