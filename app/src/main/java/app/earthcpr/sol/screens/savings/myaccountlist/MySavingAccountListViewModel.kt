package app.earthcpr.sol.screens.savings.myaccountlist

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.earthcpr.sol.models.MyAccount
import kotlinx.coroutines.launch
import javax.inject.Inject

class MySavingAccountListViewModel @Inject constructor() : ViewModel() {
    private val _myAccountListModel = mutableStateOf(MyAccountListModel())
    private val _selectedAccountNo = mutableStateOf("")
    val myAccountListModel: State<MyAccountListModel> = _myAccountListModel
    val selectedAccountNo: State<String> = _selectedAccountNo
    private val TAG: String = "SavingAccountListViewModel"

    init {
        getMySavingAccountList()
    }

    fun onClickItem(accountNo: String) {
        _selectedAccountNo.value = accountNo
    }
    fun initSelectedAccountNo() {
        _selectedAccountNo.value = ""
    }

    // 나의 적금 계좌 목록 조회 =
    fun getMySavingAccountList() {
        viewModelScope.launch {
            // coroutine
            try {
                // todo
//                val requestBody = CreateAccountRequestBody(email)
//                val userUuid = apiService.postSavingAccount(requestBody).result
//                MainActivity.preferences.setString("userUuid", userUuid ?: "")
//                MainActivity.initUserUuidIfNull()
                _myAccountListModel.value = MyAccountListModel(
                    accountList = listOf(
                        MyAccount(
                            "ESG 실천 챌린지형 적금",
                            "2024.08.18",
                            "2025.08.17",
                            "1234-123-12345",
                            "1회차",
                            2.6,
                            500000L
                        ) { onClickItem(accountNo = "1234-123-12345") },
                    ),
                    hasError = false
                )

            } catch (e: Exception) {
                Log.e(TAG, "[/api/v1/save/create/savingaccount] API ERROR OCCURED")
            }

        }
    }
}


data class MyAccountListModel(
    val accountList: List<MyAccount> = emptyList(),
    val hasError: Boolean = false
)