package controller

import dagger.Component
import view.TariffView

@Component
public interface AppComponent {
    fun getApp(): App
    fun getTariffView(): TariffView
}