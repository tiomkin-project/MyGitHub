package by.tut.tiomkin.businessmonitor_api.listeners;


import by.tut.tiomkin.businessmonitor_api.enums.FragmentAnim;
import by.tut.tiomkin.businessmonitor_api.ui.fragments.BaseFragment;

public interface MyListener {
    void setTitle(CharSequence name);
    void setTitle(int resTitleId);
    void switchFragment(BaseFragment fragment, boolean addToBackStack,
                        boolean clearBackStack, FragmentAnim fragmentAnim);
}
