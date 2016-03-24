package edu.umd.cs.continents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vibha on 3/23/16.
 */
public class ContinentNameList {


        private final List<ContinentName> items = new ArrayList<ContinentName>();

        private static final int COUNT = 7;

        public ContinentNameList() {

            addItem(new ContinentName(R.drawable.africa, "Africa"));
            addItem(new ContinentName(R.drawable.antarctica, "Antarctica"));
            addItem(new ContinentName(R.drawable.asia, "Asia"));
            addItem(new ContinentName(R.drawable.australia, "Australia"));
            addItem(new ContinentName(R.drawable.europe, "Europe"));
            addItem(new ContinentName(R.drawable.northamerica, "North America"));
            addItem(new ContinentName(R.drawable.southamerica, "South America"));
        }

        private void addItem(ContinentName item) {
            items.add(item);
        }

        public ContinentName get(int location) {
            return items.get(location);
        }
        public int size() {
            return items.size();
        }

}
