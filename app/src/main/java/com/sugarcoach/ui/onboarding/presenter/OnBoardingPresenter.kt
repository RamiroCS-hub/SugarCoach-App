package com.sugarcoach.ui.onboarding.presenter

import com.sugarcoach.R
import com.sugarcoach.ui.base.presenter.BasePresenter
import com.sugarcoach.ui.onboarding.interactor.OnBoardingInteractorImp
import com.sugarcoach.ui.onboarding.view.BoardingItem
import com.sugarcoach.ui.onboarding.view.OnBoardingView
import com.sugarcoach.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class OnBoardingPresenter<V : OnBoardingView, I : OnBoardingInteractorImp> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable),
    OnBoardingPresenterImp<V, I> {

    override fun onAttach(view: V?) {
        super.onAttach(view)
        getData()
    }

    fun getData(){
        var itemList = ArrayList<BoardingItem>()
        val oneItem = BoardingItem.Builder().bg(R.color.aqua).image(R.drawable.avatar_1).title(R.string.onboarding_item_one_title).subtitle(R.string.onboarding_item_one_subtitle).showButton(false).build()
        val twoItem = BoardingItem.Builder().bg(R.color.purple).image(R.drawable.avatar_2).title(R.string.onboarding_item_two_title).showButton(false).build()
        val threeItem = BoardingItem.Builder().bg(R.color.blue).image(R.drawable.avatar_3).title(R.string.onboarding_item_three_title).showButton(false).build()
        val fourItem = BoardingItem.Builder().bg(R.color.yellow).image(R.drawable.avatar_4).title(R.string.onboarding_item_four_title).subtitle(R.string.onboarding_item_four_subtitle).showButton(false).build()
        val fiveItem = BoardingItem.Builder().bg(R.color.pink).image(R.drawable.avatar_5).title(R.string.onboarding_item_five_title).subtitle(R.string.onboarding_item_five_subtitle).showButton(true).build()
        itemList.add(oneItem)
        itemList.add(twoItem)
        itemList.add(threeItem)
        itemList.add(fourItem)
        itemList.add(fiveItem)
        getView()?.setData(itemList)
    }

}