import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.walmart.countriesapp.CountriesResult
import com.walmart.countriesapp.Country
import com.walmart.countriesapp.CountryRepository
import com.walmart.countriesapp.CountryViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.mockito.Mockito.*
import org.mockito.kotlin.mock

@OptIn(ExperimentalCoroutinesApi::class)
class CountryViewModelTest {

    private lateinit var viewModel: CountryViewModel
    private lateinit var mockRepository: CountryRepository

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)  // Set the dispatcher for ViewModelScope
        mockRepository = mock() // Mock the repository
        viewModel = CountryViewModel(mockRepository) // Inject the mock repository into the ViewModel
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()  // Reset the main dispatcher after the test
    }

    @Test
    fun `fetchCountries updates LiveData with loading state then success`() = runTest {
        // Arrange
        val countries = listOf(Country("Washington, D.C.", "US", "United States of America", "NA"))
        `when`(mockRepository.getCountries()).thenReturn(countries) // Mock successful response

        val observer = mock<Observer<CountriesResult>>()
        viewModel.countriesLiveData.observeForever(observer)

        // Act
        viewModel.fetchCountries()

        // Assert
        verify(observer).onChanged(CountriesResult.Loading) // Loading state emitted first
        verify(observer).onChanged(CountriesResult.Success(countries)) // Success state with countries

        viewModel.countriesLiveData.removeObserver(observer)
    }

}
