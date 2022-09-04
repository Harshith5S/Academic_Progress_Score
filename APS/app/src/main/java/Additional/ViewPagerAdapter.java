package Additional;



import Fragments.ChildFragment2;
import Fragments.ChildFragment4;
import Fragments.Childfragment1;
import Fragments.Childfragment3;
import Fragments.Childfragment5;
import Fragments.Childfragment6;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] childFragments;

    public ViewPagerAdapter(FragmentManager fm) {
        super ( fm );
        childFragments = new Fragment[]{
                new Childfragment1 (), //0
                new ChildFragment2 (), //1
                new Childfragment3 (), //2
                new ChildFragment4 (), //3
                new Childfragment5 (), //4
                new Childfragment6 (), //5


        };
    }

    @Override
    public Fragment getItem(int position) {
        return childFragments[position];
    }

    @Override
    public int getCount() {
        return childFragments.length; //4 items
    }
}
