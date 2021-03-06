package com.dylanc.loadinghelper.sample.base

import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.dylanc.loadinghelper.LoadingHelper

/**
 * @author Dylan Cai
 * @since 2019/11/17
 */
abstract class BaseTitleAdapter<T : TitleConfig, VH : LoadingHelper.ViewHolder> :
  LoadingHelper.Adapter<VH>() {

  lateinit var config: T
}

open class TitleConfig(
  var titleText: String,
  var type: Type
) {
  var rightIcon = 0
    private set
  var rightText: String? = null
    private set
  var onRightBtnClickListener: View.OnClickListener? = null
    private set
  var menuId = 0
    private set
  var onMenuItemClickListener: ((MenuItem) -> Boolean)? = null
    private set

  fun setRightBtn(rightIcon: Int, onRightBtnClickListener: View.OnClickListener?) {
    this.rightIcon = rightIcon
    this.onRightBtnClickListener = onRightBtnClickListener
  }

  fun setRightBtn(rightText: String, onRightBtnClickListener: View.OnClickListener?) {
    this.rightText = rightText
    this.onRightBtnClickListener = onRightBtnClickListener
  }

  fun setMenu(menuId:Int,onMenuItemClickListener: (MenuItem) -> Boolean){
    this.menuId = menuId
    this.onMenuItemClickListener = onMenuItemClickListener
  }

  enum class Type {
    BACK, NO_BACK
  }
}
