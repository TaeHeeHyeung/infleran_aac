# infleran_aac

1. ViewModel LifeCycle 생명주기
- ViewModel: Owner의 생명 주기에 맞춰서 생존 => ViewModelProvider.Factory
- SaveSateHandle: 앱 내부에 저장 => AbstractSavedStateViewModelFactory


2. Observable, LiveData 
switchMap: LiveData Format (새로운 LiveData를 반환 시켜 다른 형식으로 반환 가능) 
map: LiveData Format (자기 자신과 동일한 형식을 반환)

3. DataBinding

4. Repository Pattern 
Database와 Network 처리를 분리, 데이터 캡슐화 
